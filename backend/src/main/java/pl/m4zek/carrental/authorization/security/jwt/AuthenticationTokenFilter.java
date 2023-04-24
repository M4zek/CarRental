package pl.m4zek.carrental.authorization.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pl.m4zek.carrental.authorization.security.service.MyUserDetailsService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        } catch (Exception e){
            logger.error("User cannot be authenticated: {}", e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
