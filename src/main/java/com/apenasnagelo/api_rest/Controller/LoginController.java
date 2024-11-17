package com.apenasnagelo.api_rest.Controller;

import com.apenasnagelo.api_rest.DTO.LoginRequest;
import com.apenasnagelo.api_rest.DTO.SectionRequest;
import com.apenasnagelo.api_rest.Model.User;
import com.apenasnagelo.api_rest.Repository.UserRepository;
import com.apenasnagelo.api_rest.Security.JWTCreator;
import com.apenasnagelo.api_rest.Security.JWTObject;
import com.apenasnagelo.api_rest.Security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public SectionRequest login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());

        if (user == null) throw new RuntimeException("User not found");

        boolean passwordMatch = encoder.matches(loginRequest.getPassword(), user.getPassword());
        if (!passwordMatch) {
            throw new RuntimeException("Invalid password");
        }

        SectionRequest sectionRequest = new SectionRequest();
        sectionRequest.setUsername(user.getUsername());

        JWTObject jwtObject = new JWTObject();
        jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
        jwtObject.setExpiration(new Date(System.currentTimeMillis() + securityConfig.EXPIRATION));
        jwtObject.setRoles(user.getRoles());

        sectionRequest.setToken(JWTCreator.create(securityConfig.PREFIX, securityConfig.KEY, jwtObject));
        return sectionRequest;
    }
}
