package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;


    @GetMapping()
    public String ind(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "/users/index";
    }
    @GetMapping("/new")
    public String newCar(Model model){
        model.addAttribute("user", new User());
        return "/users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") long id){
        User user = userService.findById(id);
        model.addAttribute("users", Arrays.asList(user));
        return "/users/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id){
        userService.updateById(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/users";
    }

}
