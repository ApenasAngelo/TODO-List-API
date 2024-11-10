package com.apenasnagelo.api_rest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String Welcome() {
        return "Welcome to my Spring Boot Web API";
    }

    @GetMapping("/user")
    public String users() {
        return "Authorized user";
    }

    @GetMapping("/admin")
    public String admins() {
        return "Authorized admin";
    }
}
