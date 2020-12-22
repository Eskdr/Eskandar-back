package com.eskdr.eskadar.controller;

import com.eskdr.eskadar.data.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("")
    public int signUp(@RequestParam(name = "id") String token) {
        User user = new User();
        return user.login(token);
    }
}
