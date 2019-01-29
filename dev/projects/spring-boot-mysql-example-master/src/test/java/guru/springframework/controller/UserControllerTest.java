package guru.springframework.controller;

import guru.springframework.controllers.UserController;
import guru.springframework.domain.User;
import guru.springframework.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by dik81 on 30.01.19.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;


    @Test
    public void testGetAllUsersInMVCController()
            throws Exception {

        User user = new User();

        List<User> allUsers = Arrays.asList(user);

        given(userService.getAllUsers()).willReturn(allUsers);

//        MvcResult mvcResult = new DefaultMvcResult();

        mvc.perform(get("/")
//                .contentType(MediaType.APPLICATION_JSON))
        )
                .andExpect(status().isOk());
//                .match(new DefaultM););
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].login", is(user.getLogin())
//                )
//        );
    }

}
