package edu.miu.cs.cs425.eregistrar.controller;
import edu.miu.cs.cs425.eregistrar.model.User;
import edu.miu.cs.cs425.eregistrar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = {"/eregistrar/api/user-management"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/list"})
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping(value = {"/user-list-by-role/{userRole}"})
    public List<User> getAllUserByRole(@PathVariable("userRole") String userRole){
        return userService.getAllUserByRole(userRole);
    }

}
