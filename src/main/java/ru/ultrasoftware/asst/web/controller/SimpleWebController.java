package ru.ultrasoftware.asst.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ultrasoftware.asst.domain.User;
import ru.ultrasoftware.asst.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class SimpleWebController {

    @Autowired
    private UserService userService;

    //ГЛАВНАЯ СТРАНИЦА
    @RequestMapping("/")
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "index";
    }
    //КОНЕЦ ГЛАВНОЙ СТРАНИЦЫ

    //ПРОЦЕДУРА РЕГИСТРАЦИИ
    @RequestMapping("/hello")
        public String registration(Map<String,Object> model, HttpServletRequest request) {
            HttpSession s = request.getSession();
            return "registration";
        }
    //ПРОЦЕДУРА РЕГИСТРАЦИИ: ПЕРЕДАЧА ДАННЫХ ИЗ ФОРМ
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    public String helloForms(@RequestParam(value="login",required=true) String login,
                             @RequestParam(value="psw",required=true) String psw,
                             @RequestParam(value="psw2",required=true) String psw2,ModelMap model)
    {
        model.addAttribute("login",login);
        model.addAttribute("psw",psw);
        model.addAttribute("psw2",psw2);
        model.put("data",login+psw+psw2);
    return "dataSent";
    }
    //КОНЕЦ ПЕРЕДАЧИ ДАННЫХ ИЗ ФОРМ
    //КОНЕЦ ПРОЦЕДУРЫ РЕГИСТРАЦИИ
}


