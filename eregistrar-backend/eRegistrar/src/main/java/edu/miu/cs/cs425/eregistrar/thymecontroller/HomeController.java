package edu.miu.cs.cs425.eregistrar.thymecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/eregistrar"})
public class HomeController {

    @GetMapping(value = {"/home"})
    public String displayHomepage(){
        return "home/index";
    }
}

