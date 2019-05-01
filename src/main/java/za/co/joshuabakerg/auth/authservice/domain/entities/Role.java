package za.co.joshuabakerg.auth.authservice.domain.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class Role implements GrantedAuthority {
    private String authority;
}
