package br.com.cineflix.controller;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
@Tag(name = "Movie", description = "Recurso responsavel pelo gerenciamento dos filmes.")
public class MovieController {

    private final MovieService service;
    public MovieController(MovieService service) {
        this.service = service;
    }

    @Operation(summary = "Salvar filme.", description = "Metodo responsavel por salvamento de um novo filme",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Filme salvo com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @PostMapping
    public ResponseEntity<MovieResponse> saveMovie(@Valid @RequestBody MovieRequest request) {

        Movie savedMovie = service.save(MovieMapper.toMovie(request));

        return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));
    }

    @Operation(summary = "Listar todos os filmes", description = "Metodo responsavel por buscar e listar todos filmes salvos",
                security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Lista de filmes salvos",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll() {

        return ResponseEntity.ok(service.findAll()
                .stream()
                .map(movie -> MovieMapper.toMovieResponse(movie))
                .toList());

    }

    @Operation(summary = "Listar filme por Id", description = "Metodo responsavel por buscar e listar filme por Id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme encontrado pelo Id",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme nao encontrado",
            content = @Content())
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id) {

        return service.findById(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Buscar filmes pela categoria", description = "Metodo responsavel por buscar e listar os filmes da categoria selecionada",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filmes encontrado com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    @ApiResponse(responseCode = "404", description = "Filme nao encontrado",
            content = @Content())
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

    @Operation(summary = "Alterar filme", description = "Metodo responsavel por alterar dados de filme salvo",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme atualizado com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme nao encontrado",
            content = @Content())
    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id ,@Valid @RequestBody MovieRequest request){
        return service.update(id, MovieMapper.toMovie(request))
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deletar filme por Id", description = "Metodo responsavel por deletar por Id filmes salvos",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Filme deletado",
            content = @Content())
    @ApiResponse(responseCode = "404", description = "Filme nao encontrado",
            content = @Content())
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id){
        Optional<Movie> optMovie = service.findById(id);
        if(optMovie.isPresent()){
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}