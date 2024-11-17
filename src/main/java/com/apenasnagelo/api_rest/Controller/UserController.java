package com.apenasnagelo.api_rest.Controller;

import com.apenasnagelo.api_rest.DTO.ChangePasswordRequest;
import com.apenasnagelo.api_rest.Model.User;
import com.apenasnagelo.api_rest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        service.registerUser(user);
    }

    @PutMapping("/change-password")
    public void changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        service.changePassword(changePasswordRequest);
    }
}