package guru.springframework.controllers;

import guru.springframework.domain.Note;
import guru.springframework.domain.User;
import guru.springframework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Arrays;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String redirToList(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "product/users";
    }

//    @RequestMapping("/product/show/{id}")
//    public String getProduct(@PathVariable String id, Model model){
//        model.addAttribute("product", productService.getById(Long.valueOf(id)));
//        return "product/show";
//    }

    @RequestMapping("user/edit/{id}")
    public String editUser(@PathVariable String id, Model model){
        User user = userService.getUserById(Integer.valueOf(id));
        model.addAttribute("user", user);
        return "product/addEditUser";
    }

    @RequestMapping("/user/new")
    public String newUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "product/addEditUser";
    }


    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String saveOrUpdateUser(@Valid User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "product/addEditUser";
        }

        User savedUser = userService.saveOrUpdateUser(user);

        return "redirect:/";
    }

    @RequestMapping("/user/delete/{id}")
    public String delete(@PathVariable String id){
        userService.deleteUser(Integer.valueOf(id));
        return "redirect:/";
    }

    @RequestMapping("/user/show/notes/{id}")
    public String showUserNotes(@PathVariable String id, Model model){
        model.addAttribute("notes", Arrays.asList(new Note("note1"), new Note("note2")));
        return "product/notes";
    }
}
