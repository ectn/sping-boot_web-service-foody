package com.ctinute.foody.controller;

import com.ctinute.foody.dao.UserDAO;
import com.ctinute.foody.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {
    @RequestMapping("/login")
    public List<User> getUser(
            @RequestParam(value="email") String email,
            @RequestParam(value="password") String password
    ) {
        List<User> users = new ArrayList<>();
        UserDAO udb = new UserDAO();
        User user = udb.getUser(email,password);
        if (user!= null)
            users.add(user);
        udb.close();
        return users;
    }
}
