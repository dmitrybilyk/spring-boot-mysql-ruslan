package guru.springframework.services;

import guru.springframework.domain.User;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by dik81 on 28.01.19.
 */
public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();
    User getUserById(Integer id);
    void deleteUser(Integer id);
    User saveOrUpdateUser(User user);
}
