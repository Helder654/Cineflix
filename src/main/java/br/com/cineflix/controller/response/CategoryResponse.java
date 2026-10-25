package br.com.cineflix.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder 
public record CategoryResponse(@Schema(type = "Long", description = "Id da categoria")
                               Long id,
                               @Schema(type = "String", description = "Nome da categoria")
                               String name) {

}
