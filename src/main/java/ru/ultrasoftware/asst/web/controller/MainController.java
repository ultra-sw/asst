package ru.ultrasoftware.asst.web.controller;

import java.security.Principal;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import ru.ultrasoftware.asst.web.controller.WebUtils;
import ru.ultrasoftware.asst.domain.AppUser;
 
@Controller
public class MainController {

    final String TITLE = "title";

    void setTitle(Model model, String object){
        model.addAttribute(TITLE, object);
    }

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String index(Model model) {
        setTitle(model,"Welcome");

        model.addAttribute("message", "This is welcome page!");

        return "index";
    }
 
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
         
        return "dashboard";
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
 
        return "login";
    }
 
    @RequestMapping(value = "/logout-successful", method = RequestMethod.GET)
    public String logoutSuccessful(Model model) {
        model.addAttribute("title", "Logout");
        return "logout_successful";
    }
 
    @RequestMapping(value = "/user-info", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
 
        // (1) (en)
        // After user login successfully.
        // (vi)
        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();
 
        System.out.println("User Name: " + userName);
 
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
 
        return "user_info";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        return "registration";
    }

    //ПРОЦЕДУРА РЕГИСТРАЦИИ: ПЕРЕДАЧА ДАННЫХ ИЗ ФОРМ
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    //перехватываем введённые параметры из форм на странице registration.html
    public String helloForms(@RequestParam(value="login",required=true) String login,
                             @RequestParam(value="psw",required=true) String psw,
                             @RequestParam(value="psw2",required=true) String psw2, ModelMap model)
    {
        //добавление параметров в модель. Теперь можно передать их на веб-страницу
        model.addAttribute("login",login);
        model.addAttribute("psw",psw);
        model.addAttribute("psw2",psw2);
        model.put("data","Your data:"+"Login: "+login+", Password: "+psw);
        //На страницу dataSent.html добавляем:
        //<p th:text="'Hello, ' + ${data} + '!'"></p>
    return "tmp/dataSent";
        //Открылась страница, на которой написаны все данные из форм

    }
    //КОНЕЦ ПРОЦЕДУРА РЕГИСТРАЦИИ: ПЕРЕДАЧА ДАННЫХ ИЗ ФОРМ

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
            String userInfo = WebUtils.toString(loginedUser);
 
            model.addAttribute("userInfo", userInfo);
 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
 
        return "403";
    }
 
}