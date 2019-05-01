package za.co.joshuabakerg.auth.authservice.config;

import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Profile("off")
@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;

    public AuthenticationProviderImpl(final UserDetailsService userDetailsServiceImpl,
                                      final PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsServiceImpl;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String username = (String) authentication.getPrincipal();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(passwordEncoder.matches((CharSequence) token.getCredentials(), userDetails.getPassword())) {
            UsernamePasswordAuthenticationToken newToken = new UsernamePasswordAuthenticationToken(userDetails, token.getCredentials(), userDetails.getAuthorities());
            newToken.setDetails(token.getDetails());
            return newToken;
        }
        throw new BadCredentialsException("Credentials are incorrect");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication));
    }

}
