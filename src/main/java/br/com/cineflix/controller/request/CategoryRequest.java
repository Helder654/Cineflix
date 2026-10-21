package br.com.cineflix.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record  CategoryRequest(@NotEmpty(message = "Nome da categoria e obrigatorio") String name) {

}
