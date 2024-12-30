package cl.cursospring.curso_spring.configuration;

import org.springdoc.core.models.GroupedOpenApi;
//import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;


@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi apis(){
        return GroupedOpenApi.builder()
        .group("public-apis")
        .pathsToMatch("/**")
        .build();
    }

    @Bean
    OpenAPI customOpenAPI(){
        return new OpenAPI()
            .info(new Info()
            .title("API REST")
            .description("API REST para el curso de Spring")
            .version("1.0.0"))
        .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
        .components(new Components()
            .addSecuritySchemes("bearerAuth", new SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT")));
    }

}
