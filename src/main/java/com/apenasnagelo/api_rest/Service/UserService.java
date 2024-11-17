package com.apenasnagelo.api_rest.Service;

import com.apenasnagelo.api_rest.DTO.ChangePasswordRequest;
import com.apenasnagelo.api_rest.Exception.InvalidPasswordException;
import com.apenasnagelo.api_rest.Exception.UserNotFoundException;
import com.apenasnagelo.api_rest.Model.User;
import com.apenasnagelo.api_rest.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void registerUser(User user) {
        String password = user.getPassword();
        user.setPassword(encoder.encode(password));
        userRepository.save(user);
    }

    public void changePassword(ChangePasswordRequest changePasswordRequest) {
        User user = userRepository.findByUsername(changePasswordRequest.getUsername());
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        if (!encoder.matches(changePasswordRequest.getOldPassword(), user.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }
        user.setPassword(encoder.encode(changePasswordRequest.getNewPassword()));
        userRepository.save(user);
    }
}
