package guru.springframework.repositories;

import guru.springframework.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {
    public static final String PASSORD_VALUE = "passord value";
    public static final String LOGIN_VALUE = "loginValue";

    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private UserRepository userRepository;

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
    // write test cases here
 
}
