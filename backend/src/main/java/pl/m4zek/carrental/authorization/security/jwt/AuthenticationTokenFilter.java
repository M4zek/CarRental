package pl.m4zek.carrental.authorization.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pl.m4zek.carrental.authorization.advice.ErrorMessage;
import pl.m4zek.carrental.authorization.security.service.MyUserDetailsService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    public static final Logger logger = LoggerFactory.getLogger(AuthenticationTokenFilter.class);

    private final TokenManager tokenManager;

    private final MyUserDetailsService myUserDetailsService;

    public AuthenticationTokenFilter(TokenManager tokenManager, MyUserDetailsService myUserDetailsService) {
        this.tokenManager = tokenManager;
        this.myUserDetailsService = myUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = tokenManager.parseJwt(request);
            if(token != null && tokenManager.validateToken(token)){
                String username = tokenManager.getUsernameFromToken(token);

                UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException exception){
            logger.error("User cannot be authenticated: {}", exception.getMessage());
            handleJwtExpiredException(request, response, exception);
        }
    }

    private void handleJwtExpiredException(HttpServletRequest request, HttpServletResponse response, ExpiredJwtException ex) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        ErrorMessage errorMessage = new ErrorMessage(
                HttpStatus.UNAUTHORIZED.value(),
                new Date(),
                String.format("JWT has expired at [%s]", new Date(ex.getClaims().getExpiration().getTime())),
                "Refresh the token or log in again"
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(errorMessage);

        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);
    }

}
