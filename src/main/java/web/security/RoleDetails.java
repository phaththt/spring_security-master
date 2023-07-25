package web.security;


import org.springframework.security.core.GrantedAuthority;
import web.model.Role;

public class RoleDetails implements GrantedAuthority {
    private Role role;

    @Override
    public String getAuthority() {
        return this.role.getName();
    }

}
