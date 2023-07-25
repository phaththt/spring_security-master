package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.Role;
import web.repository.RoleRepository;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }

    @Override
    public void addRole(Role role) {
        roleRepository.addRole(role);
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Set<Role> findByIdRoles(List<Long> roles) {
        return roleRepository.findByIdRoles(roles);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }
}
