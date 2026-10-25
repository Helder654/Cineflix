package br.com.cineflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginRequest(@Schema(type = "String", description = "Email de login")
                           String email,
                           @Schema(type = "String", description = "Senha de login")
                           String password){
}
