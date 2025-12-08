package com.uab.taller.michel.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(apiInfo());
    }
    public Info apiInfo(){
        return new Info().title("Store service")
                .description("es una aplicacion bancaria")
                .version("0.0.1")
                .license(new License().name("Apache 2.0")
                        .url("https:www.apache.org/licenses/LICENSE-2.0"))
                .contact(new Contact().name("Michel")
                        .email("michel.aguirre@uab.edu.bo")
                        .url("https://www.instagram.com/instagram/"));

    }
}
