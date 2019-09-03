package za.co.joshuabakerg.auth.authservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Joshua Baker on 26/08/2019
 */
@Controller
public class LoginController {

    @GetMapping("login")
    public String login() {
        return "login";
    }

}
