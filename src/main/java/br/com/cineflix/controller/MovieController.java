package br.com.cineflix.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cineflix.controller.request.MovieRequest;
import br.com.cineflix.controller.response.MovieResponse;
import br.com.cineflix.entity.Movie;
import br.com.cineflix.mapper.MovieMapper;
import br.com.cineflix.service.MovieService;

@RestController
@RequestMapping("/cineflix/movie")

public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }
     
    @PostMapping
    public ResponseEntity<MovieResponse> saveMovie(@RequestBody MovieRequest request){

    Movie savedMovie = service.save(MovieMapper.toMovie(request));
    
    return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));
}

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll(){

        return ResponseEntity.ok(service.findAll()
                .stream()
                .map(movie -> MovieMapper.toMovieResponse(movie))
                .toList());

    }


}
