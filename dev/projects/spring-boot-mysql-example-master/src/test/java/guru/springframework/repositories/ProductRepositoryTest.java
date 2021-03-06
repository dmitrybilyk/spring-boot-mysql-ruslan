package guru.springframework.repositories;

import guru.springframework.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    public static final String PASSORD_VALUE = "passord value";
    public static final String LOGIN_VALUE = "loginValue";

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistence() {
        //given
        User user = new User();
        user.setPassord(PASSORD_VALUE);
        user.setLogin(LOGIN_VALUE);

        //when
        userRepository.save(user);

        //then
        Assert.assertNotNull(user.getUserId());
        User newUser = userRepository.findById(user.getUserId()).orElse(null);
        Assert.assertEquals(LOGIN_VALUE, newUser.getLogin());
        Assert.assertEquals(PASSORD_VALUE, newUser.getPassord());
    }
}