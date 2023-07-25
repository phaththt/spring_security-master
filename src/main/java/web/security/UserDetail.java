package web.security;

import org.springframework.security.core.GrantedAuthority;
import web.model.User;

import java.util.Collection;

public class UserDetail implements org.springframework.security.core.userdetails.UserDetails {
    private User user;

    public UserDetail(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getName();
    }

/*    public String getUserLastname() {
        return this.user.getLastname();
    }

    public Long getUserAge() {
        return this.user.getAge();
    }*/

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
