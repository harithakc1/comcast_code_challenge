package org.src;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // <-- added
@OpenAPIDefinition(info = @Info(title = "adequate-shop-application", description = "Adequate shop Services", version = "v1"))
@SecurityScheme(name = "security_auth", scheme = "api_key", type = SecuritySchemeType.APIKEY, paramName = "JWT", in = SecuritySchemeIn.HEADER)
public class AdequateShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdequateShopApplication.class, args);

    }
}