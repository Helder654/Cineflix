package br.com.cineflix.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(@Schema(type = "String", description = "Nome do filme")
                           @NotEmpty(message = "Titulo do filme e obrigatorio")
                           String title,
                           @Schema(type = "String", description = "Descricao do filme")
                           String description,
                           @Schema(type = "date", description = "Data de lancamento do filme ex: 'dd/MM/yyyy'")
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           LocalDate releaseDate,
                           @Schema(type = "double", description = "Nota do filme de 0 a 10")
                           double rating,
                           @Schema(type = "Array", description = "Categorias do filme")
                           List<Long> categories,
                           @Schema(type = "Array", description = "Streamings que tem o filme disponivel")
                           List<Long> streamings) {

}
