package web.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import web.model.Role;

import java.util.List;
import java.util.Set;
@Service
public interface RoleService {
    List<Role> getAllRoles ();
    void addRole(Role role);
    Role findById(long id);
    Set<Role> findByIdRoles(List<Long>roles);

    Role getRoleByName(String name);
}
