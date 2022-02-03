package edu.miu.cs.cs425.eregistrar.thymecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/eregistrar"})
public class LoginController {
    @GetMapping(value = {"/login"})
    public String displayLogin(){
        return "public/login";
    }
}
