package com.apenasnagelo.api_rest.Controller;

import com.apenasnagelo.api_rest.DTO.ChangePasswordRequest;
import com.apenasnagelo.api_rest.Exceptions.InvalidPasswordException;
import com.apenasnagelo.api_rest.Exceptions.UserNotFoundException;
import com.apenasnagelo.api_rest.Model.User;
import com.apenasnagelo.api_rest.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @PutMapping("/change-password")
    public void changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        User user = userRepository.findByUsername(changePasswordRequest.getUsername());
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        if (!passwordEncoder.matches(changePasswordRequest.getOldPassword(), user.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }
        user.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
        userRepository.save(user);
    }
}