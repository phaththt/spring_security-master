package web.repository;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from users u").getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void removeUser(long id) {
        entityManager.remove(id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return entityManager
                .createQuery("select u from Users u where u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();

    }
}
