package com.ctinute.foody.controller;

import com.ctinute.foody.dao.UserDAO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @RequestMapping("/register")
    public Boolean getUser(
            @RequestParam(value="email") String email,
            @RequestParam(value="password") String password,
            @RequestParam(value="name") String name
    ) {
        UserDAO udb = new UserDAO();
        boolean success = udb.registerUser(name,email,password);
        udb.close();
        return success;
    }
}
