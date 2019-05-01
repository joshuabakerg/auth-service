package za.co.joshuabakerg.auth.authservice.core;

import org.springframework.security.core.userdetails.UserDetails;

public interface TokenService {

    String getToken(String username, String password);

    String getUsernameFromToken(String token);

}
