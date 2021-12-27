package com.demo.example;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String appDescription, @Value("${application-version}")
                                 String appVersion) {
        return new OpenAPI().info(new Info().title("Player Swagger Application")
                .version(appVersion)
                .description(appDescription)
                .termsOfService("http://termsOfService")
                .license(new License().name("PLayers Licence @Copyright2010").url("http://playerLicenceAgreement")));
    }
}
