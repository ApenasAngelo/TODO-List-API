package com.apenasnagelo.api_rest.doc;

import io.swagger.v3.core.model.ApiDescription;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    private Contact contact() {
        return new Contact()
                .name("Seu nome")
                .url("https://meusite.com")
                .email("voce@seusite.com");
    }

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("API REST")
                        .description("API REST com Spring Boot")
                        .version("1.0.0")
                        .termsOfService("https://swagger.io/terms/")
                        .contact(this.contact())
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0"))

                );
    }
}
