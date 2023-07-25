package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;
import web.security.UserDetail;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public void setUserRepo(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void addUser(User user) {
    userRepository.addUser(user);
    }

    @Override
    public void removeUser(long id) {
    userRepository.removeUser(id);
    }

    @Override
    public void updateUser(User user) {
    userRepository.updateUser(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.getUserByUsername(username));
        return new UserDetail(user.get());
    }

}


