package ru.ultrasoftware.asst.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ultrasoftware.asst.domain.User;
import ru.ultrasoftware.asst.service.UserService;

import java.util.List;

@Controller
public class SimpleWebController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "hello";
    }
}
