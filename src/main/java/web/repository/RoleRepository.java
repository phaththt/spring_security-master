package web.repository;

import org.springframework.stereotype.Repository;
import web.model.Role;

import java.util.List;
import java.util.Set;


public interface RoleRepository {

    List<Role> getAllRoles ();
    void addRole(Role role);
    Role findById(long id);
    Set<Role> findByIdRoles(List<Long>roles);

    Role getRoleByName(String name);

}
