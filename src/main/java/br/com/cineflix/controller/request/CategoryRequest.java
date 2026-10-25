package br.com.cineflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record  CategoryRequest(@NotEmpty(message = "Nome da categoria e obrigatorio")
                               @Schema(type = "String", description = "Nome da categoria")
                               String name) {

}
