package sk.matusko.ecs.authentication.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sk.matusko.ecs.authentication.interfaces.Owner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable, Owner, UserDetails {

    private static final long serialVersionUID = 9160056901518133045L;

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstname")
    private String firstName;

    @NotNull(message = "1")
    @Column(name = "lastname")
    private String lastName;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    @JsonIgnore
    public User getOwner() {
        return this;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        return authorities;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        // we never lock accounts
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        // credentials never expire
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return username;
    }
}
