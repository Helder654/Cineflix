package br.com.cineflix.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record StreamingResponse(@Schema(type = "Long", description = "Id do servico de streaming")
                                Long id,
                                @Schema(type = "String", description = "Nome do servico de streaming")
                                String name) {

}
