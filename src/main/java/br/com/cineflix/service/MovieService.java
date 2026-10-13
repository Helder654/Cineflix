package br.com.cineflix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.cineflix.entity.Category;
import br.com.cineflix.entity.Streaming;
import org.springframework.stereotype.Service;

import br.com.cineflix.entity.Movie;
import br.com.cineflix.repository.MovieRepository;

@Service 

public class MovieService {

    private final MovieRepository repository;

    private final CategoryService categoryService;

    private final StreamingService streamingService;

    public MovieService(MovieRepository repository, CategoryService categoryService, StreamingService streamingService) {
        this.repository = repository;
        this.categoryService = categoryService;
        this.streamingService = streamingService;
    }

    public Movie save(Movie movie) {

        movie.setCategories(this.findCategory(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));

        return repository.save(movie);
    }

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public Optional<Movie> findById(Long id){
        return repository.findById(id);
    }

    private List<Category> findCategory(List<Category> categories) {
        List<Category> categoriesFound = new ArrayList<>();
        for (Category category : categories) {
            categoryService.findById(category.getId()).ifPresent(categoriesFound::add);
        }
        return categoriesFound;
    }
    private List<Streaming> findStreamings(List<Streaming> streamings) {
        List<Streaming> streamingsFound = new ArrayList<>();
        for (Streaming streaming : streamings) {
            streamingService.findById(streaming.getId()).ifPresent(streamingsFound::add);
        }
        return streamingsFound;
    }
}