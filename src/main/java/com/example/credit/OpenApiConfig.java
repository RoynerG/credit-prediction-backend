package com.example.credit;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI creditApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Predicción de Crédito")
                        .version("1.0.0")
                        .description("Servicio REST que predice la probabilidad de buen/mal crédito usando un modelo WEKA"));
    }
}
