package com.sheepdivide.master.control;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.unbescape.html.HtmlEscape;

@Controller
public class MainController {

    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("/authorized/home.html")
    public String home(){
        return "authorized/home";
    }

}

