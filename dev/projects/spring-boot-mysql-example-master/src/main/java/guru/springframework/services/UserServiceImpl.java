package guru.springframework.services;

import guru.springframework.domain.User;
import guru.springframework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dik81 on 28.01.19.
 */
@Service
public class UserServiceImpl implements UserService {
    Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> target = new ArrayList<>();
        userRepository.findAll().forEach(target::add);
        logger.info("Fetching all users in info {}", 3);
        logger.debug("Fetching all users in debug{}", 3);
        return target;
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }
}
