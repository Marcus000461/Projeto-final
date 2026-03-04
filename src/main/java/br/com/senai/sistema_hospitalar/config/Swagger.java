package br.com.senai.sistema_hospitalar.config;

import org.springframework.context.annotation.Configuration;

    @Configuration
    @OpenAPIDefinition(
    info = @info(
        title = "Exemplo API",
        version = "1.0",
        description = "API para o sistema Exemplo"
    )
)
public class Swagger {

}
