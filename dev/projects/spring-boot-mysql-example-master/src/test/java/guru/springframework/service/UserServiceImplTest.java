package guru.springframework.service;

import guru.springframework.domain.User;
import guru.springframework.repositories.UserRepository;
import guru.springframework.services.UserService;
import guru.springframework.services.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dik81 on 29.01.19.
 */
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testGetAllUsers(){
        Mockito.when(userRepository.findAll()).thenReturn(Arrays.<User>asList(new User()));
        List<User> userList = userService.getAllUsers();
        Assert.assertEquals(1, userList.size());
    }
}
