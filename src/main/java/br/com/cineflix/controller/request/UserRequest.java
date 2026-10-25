package br.com.cineflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserRequest(@Schema(type = "String", description = "Nome do usuario")
                          String name,
                          @Schema(type = "String", description = "Email do usuario")
                          String email,
                          @Schema(type = "String", description = "Senha do usuario")
                          String password) {
}
