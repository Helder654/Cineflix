package br.com.cineflix.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cineflix.entity.Movie;
import br.com.cineflix.repository.MovieRepository;

@Service 

public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Movie save(Movie movie){
        return repository.save(movie);
    }

    public List<Movie> findAll(){
        return repository.findAll();
    }

}
