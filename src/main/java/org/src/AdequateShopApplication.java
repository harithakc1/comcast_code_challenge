package org.src;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "adequate-shop-application", description = "Adequate shop Services", version = "v1"))
@SecurityScheme(name = "security_auth", scheme = "api_key", type = SecuritySchemeType.APIKEY, paramName = "JWT", in = SecuritySchemeIn.HEADER)
public class AdequateShopApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");
            new SortingDelegator();
            SpringApplication.run(AdequateShopApplication.class, args);

    }
}