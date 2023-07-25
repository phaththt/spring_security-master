package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;
@Service
public interface UserService extends UserDetailsService {
    List<User> getAllUsers ();
    User getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user);

}
