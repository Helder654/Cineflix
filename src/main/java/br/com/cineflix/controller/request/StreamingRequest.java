package br.com.cineflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder 
public record StreamingRequest(@NotEmpty(message = "Nome do streaming e obrigatorio")
                               @Schema(type = "String", description = "Nome do Servico de streaming")
                               String name) {

}
