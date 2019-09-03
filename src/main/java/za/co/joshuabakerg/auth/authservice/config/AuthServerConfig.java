package za.co.joshuabakerg.auth.authservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;

/**
 * @author Joshua Baker on 26/08/2019
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${user.oauth.clientId}")
    private String ClientID;
    @Value("${user.oauth.clientSecret}")
    private String ClientSecret;
    @Value("${user.oauth.redirectUris}")
    private String RedirectURLs;

    private final PasswordEncoder passwordEncoder;
    private final ClientDetailsService clientDetailsServiceImpl;

    public AuthServerConfig(PasswordEncoder passwordEncoder, ClientDetailsService clientDetailsServiceImpl) {
        this.passwordEncoder = passwordEncoder;
        this.clientDetailsServiceImpl = clientDetailsServiceImpl;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsServiceImpl);
    }
}
