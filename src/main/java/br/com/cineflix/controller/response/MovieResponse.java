package br.com.cineflix.controller.response;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder 
public record MovieResponse(@Schema(type = "Long", description = "Id do filme")
                            Long id,
                            @Schema(type = "String", description = "Nome do filme")
                            String title,
                            @Schema(type = "String", description = "Descricao do filme")
                            String description,
                            @Schema(type = "LocalDate", description = "Data de lancamento do filme ex: 'dd/MM/yyyy'")
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                            LocalDate releasedate,
                            @Schema(type = "Double", description = "Nota do filme")
                            double rating,
                            @Schema(type = "Array", description = "Categorias do filme")
                            List<CategoryResponse> categories,
                            @Schema(type = "Array", description = "Streamings que tem o filme disponivel")
                            List<StreamingResponse> streamings) {

}
