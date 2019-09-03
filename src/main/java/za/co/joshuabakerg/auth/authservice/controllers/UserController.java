package za.co.joshuabakerg.auth.authservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping(value = "/user/me")
    public Principal user(Principal principal) {
        return principal;
    }

}
