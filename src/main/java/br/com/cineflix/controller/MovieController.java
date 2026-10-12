package br.com.cineflix.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cineflix.service.MovieService;

@RestController
@RequestMapping("/cineflix/movie")

public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }
     


}
