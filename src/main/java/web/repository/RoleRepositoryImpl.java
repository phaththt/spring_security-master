package web.repository;


import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from roles r").getResultList();
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role findById(long id) {
        return entityManager.find(Role.class,id);
    }

    @Override
    public Set<Role> findByIdRoles(List<Long> roles) {
        TypedQuery<Role> q = entityManager.createQuery("select r from Roles r where r.id in :role", Role.class);
        q.setParameter("role",roles);
        return new HashSet<>(q.getResultList());
    }

    @Override
    public Role getRoleByName(String name) {
        Role role = null;
        try {
            role = entityManager
                    .createQuery("SELECT r FROM Roles r WHERE r.name=:name", Role.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("Роли с таким именем не существует!");
        }
        return role;
    }

}

