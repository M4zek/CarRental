package pl.m4zek.carrental.authorization.security.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pl.m4zek.carrental.authorization.security.service.MyUserDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class TokenManager {

    public static final Logger logger = LoggerFactory.getLogger(TokenManager.class);


    @Value("${jwt.token.secretKey}")
    private String SECRET_KEY;

    @Value("${jwt.token.expirationSec}")
    private long EXPIRATION;

    @Value("${jwt.token.header}")
    private String HEADER;

    @Value("${jwt.token.prefix}")
    private String PREFIX;

    public String generateToken(Authentication authentication){
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(myUserDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public String generateTokenFromUsername(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRATION * 1000))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e){
            logger.error("Invalid token {}", e.getMessage());
        } catch (SignatureException e){
            logger.error("Invalid token signature {}", e.getMessage());
        } catch (ExpiredJwtException e){
            logger.error("Token is expired {}", e.getMessage());
        } catch (UnsupportedJwtException e){
            logger.error("Token is unsupported {}", e.getMessage());
        } catch (IllegalArgumentException e){
            logger.error("Token claims is empty {}", e.getMessage());
        }
        return false;
    }

    public String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader(HEADER);

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(PREFIX)) {
            return headerAuth.substring(7);
        }

        return null;
    }
}
