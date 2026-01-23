package com.allan_dev.projeto_ponto_eletronico.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
public class SwagguerConfig {


    @Bean
    public OpenAPI OpenAPIgetOpenAPI () {

        Contact contact= new Contact();
        contact.name("Allan Isaac");
        contact.email("allanisaac.dev@gmail.com");
        contact.setUrl("https://github.com/Allan8606/ponto-eletronico-springSecurity");

        Info info = new Info();
        info.title("Registro de Ponto Eletrônico");
        info.version("v1");
        info.description("Aplicação para gerenciamento e registro de ponto eletronico");
        info.contact(contact);

        return new OpenAPI().info(info);

    }
}
