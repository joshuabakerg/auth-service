package za.co.joshuabakerg.auth.authservice.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import lombok.Data;

@Document(collection = "User")
@Data
public class User implements UserDetails {

    @Id
    @JsonIgnore
    private ObjectId id;

    private String username;

    private String password;

    private Name name;

    private Contact contact;

    private Picture picture;

    private Collection<Role> roles;

    private boolean accountExpired;

    private boolean accountLocked;

    private boolean credentialsExpired;

    private boolean enabled;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return !accountExpired;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return !credentialsExpired;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return enabled;
    }
}
