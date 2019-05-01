package za.co.joshuabakerg.auth.authservice.controllers;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import za.co.joshuabakerg.auth.authservice.core.TokenService;
import za.co.joshuabakerg.auth.authservice.domain.entities.User;

@RestController("/user")
public class UserController {

    private UserDetailsService userDetailsServiceImpl;
    private TokenService tokenService;

    public UserController(final UserDetailsService userDetailsServiceImpl,
                          final TokenService tokenService) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.tokenService = tokenService;
    }

    @GetMapping
    public UserDetails getUser(@RequestHeader("Authorization") String authorization){
        final String username = tokenService.getUsernameFromToken(authorization);
        User userEntity = (User) userDetailsServiceImpl.loadUserByUsername(username);
        userEntity.setPassword(null);
        return userEntity;
    }

}
