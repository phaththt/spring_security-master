package web.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository {
    List<User> getAllUsers ();
    User getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user);

    User getUserByUsername(String username);



}
