package br.com.cineflix.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserResponse(@Schema(type = "Long", description = "Id do usuario")
                           Long id,
                           @Schema(type = "String", description = "Nome do usuario")
                           String name,
                           @Schema(type = "String", description = "Email do usuario")
                           String email) {
}
