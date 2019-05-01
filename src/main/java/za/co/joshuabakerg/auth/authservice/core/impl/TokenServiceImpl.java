package za.co.joshuabakerg.auth.authservice.core.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.co.joshuabakerg.auth.authservice.core.TokenService;
import za.co.joshuabakerg.auth.authservice.core.exceptions.InvalidJavaWebToken;

import java.util.LinkedHashMap;

@Service
public class TokenServiceImpl implements TokenService {

    public static final String SIGNING_KEY = "test";
    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;
    private ObjectMapper objectMapper;

    public TokenServiceImpl(final UserDetailsService userDetailsServiceImpl,
                            final PasswordEncoder passwordEncoder,
                            final ObjectMapper objectMapper) {
        userDetailsService = userDetailsServiceImpl;
        this.passwordEncoder = passwordEncoder;
        this.objectMapper = objectMapper;
    }

    @Override
    public String getToken(String username, String password) {
        final UserDetails user = userDetailsService.loadUserByUsername(username);
        if (passwordEncoder.matches(password, user.getPassword())) {
            return Jwts.builder()
                    .setSubject(username)
                    .setClaims(objectMapper.convertValue(user, LinkedHashMap.class))
                    .signWith(SignatureAlgorithm.HS512, SIGNING_KEY)
                    .compact();
        }
        throw new BadCredentialsException("Credentials are incorrect");
    }

    @Override
    public String getUsernameFromToken(final String token) {
        try {
            return (String) Jwts.parser()
                    .setSigningKey(SIGNING_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .get("username");
        } catch (JwtException e) {
            throw new InvalidJavaWebToken("Token is not valid");
        }
    }
}
