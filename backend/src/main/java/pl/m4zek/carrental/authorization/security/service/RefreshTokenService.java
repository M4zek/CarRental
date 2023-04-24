package pl.m4zek.carrental.authorization.security.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.m4zek.carrental.authorization.exception.RefreshTokenException;
import pl.m4zek.carrental.authorization.model.RefreshToken;
import pl.m4zek.carrental.authorization.model.User;
import pl.m4zek.carrental.authorization.repository.RefreshTokenRepository;
import pl.m4zek.carrental.authorization.repository.UserRepository;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Value("${jwt.token.refreshExpirationSec}")
    private Long refreshTokenExpiration;

    private final UserRepository userRepository;

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenService(UserRepository userRepository, RefreshTokenRepository refreshTokenRepository) {
        this.userRepository = userRepository;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public RefreshToken createRefreshToken(String user_id){
        User user = userRepository.findById(user_id).get();

        if(refreshTokenRepository.existsByUser(user)) {
            deleteByUserId(user_id);
        }

        return refreshTokenRepository.save(new RefreshToken(
                user,
                UUID.randomUUID().toString(),
                Instant.now().plusMillis(refreshTokenExpiration * 1000)
        ));
    }

    public RefreshToken updateExpirationTime(RefreshToken refreshToken){
        if(refreshToken.getExpireDate().compareTo(Instant.now()) > 0) {
            refreshToken.setExpireDate(Instant.now().plusMillis(refreshTokenExpiration * 1000));
            refreshToken = refreshTokenRepository.save(refreshToken);
        }
        return refreshToken;
    }

    public RefreshToken verifyExpiration(RefreshToken refreshToken){
        if(refreshToken.getExpireDate().compareTo(Instant.now()) < 0){
            refreshTokenRepository.delete(refreshToken);
            throw new RefreshTokenException(refreshToken.getToken(), "Session has expired, please log in again!");
        }
        return refreshToken;
    }

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public void deleteByUserId(String id){
         refreshTokenRepository.deleteByUser(userRepository.findById(id).get());
    }

}
