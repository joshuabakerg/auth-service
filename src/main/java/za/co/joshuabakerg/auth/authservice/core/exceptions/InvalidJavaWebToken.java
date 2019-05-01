package za.co.joshuabakerg.auth.authservice.core.exceptions;

import org.springframework.security.core.AuthenticationException;

public class InvalidJavaWebToken extends AuthenticationException {

    public InvalidJavaWebToken(String msg, Throwable t) {
        super(msg, t);
    }

    public InvalidJavaWebToken(String msg) {
        super(msg);
    }
}
