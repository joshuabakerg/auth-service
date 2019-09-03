package za.co.joshuabakerg.auth.authservice.controllers;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping(value = "/user/me")
    public Principal user(OAuth2Authentication principal) {
        return principal.getUserAuthentication();
    }

}
