package za.co.joshuabakerg.auth.authservice.controllers;

import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.*;
import za.co.joshuabakerg.auth.authservice.core.TokenService;

@RestController("/token")
public class TokenController {

    private TokenService tokenService;

    public TokenController(final TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping
    public String getToken(@RequestParam String username, @RequestParam String password) {
        return tokenService.getToken(username, password);
    }

}
