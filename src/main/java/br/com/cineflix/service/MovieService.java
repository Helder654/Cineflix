package br.com.cineflix.service;

import org.springframework.stereotype.Service;

import br.com.cineflix.repository.MovieRepository;

@Service 

public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

}
