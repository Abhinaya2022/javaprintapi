package com.audree.audreeprintservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
    	return new OpenAPI()
                .info(new Info()
                		.title("Print Service API")
                		.version("v1")
                		.description("API for handling print requests"))
                .components(new Components()
                		.addSecuritySchemes("bearerAuth", new SecurityScheme()
                				.type(SecurityScheme.Type.HTTP).scheme("bearer")
                				.bearerFormat("JWT")));
    }
}
