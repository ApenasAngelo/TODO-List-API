package com.apenasnagelo.api_rest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String Welcome() {
        return "Welcome to my Spring Boot Web API";
    }
}
