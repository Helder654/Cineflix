package br.com.cineflix.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<MovieResponse> saveMovie(@RequestBody MovieRequest request) {

        Movie savedMovie = service.save(MovieMapper.toMovie(request));

        return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll() {

        return ResponseEntity.ok(service.findAll()
                .stream()
                .map(movie -> MovieMapper.toMovieResponse(movie))
                .toList());

    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id) {

        return service.findById(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
        public ResponseEntity<List<MovieResponse>> findByCategory(
            @RequestParam List<Long> category) {

        return ResponseEntity.ok(
            service.findByCategories(category)
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList()
        );
}

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id , @RequestBody MovieRequest request){
        return service.update(id, MovieMapper.toMovie(request))
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }
}