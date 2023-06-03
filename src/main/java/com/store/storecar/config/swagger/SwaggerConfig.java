package com.store.storecar.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI cusmOpenAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("Micro servico Veiculos")
                        .version("0.0.1")
                        .description("Micro servico para gerenciamento de veiculos"));
    }

}
