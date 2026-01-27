package com.platzi.play.web.controller;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.SuggestRequestDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.domain.service.MovieService;
import com.platzi.play.domain.service.PlatziPlayAiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name="Movies", description = "Operations about movies of PlatziPlay")
public class MovieController {

    private final MovieService movieService;
    private final PlatziPlayAiService aiService;
    private final String platform;

    public MovieController(@Value("${spring.application.name}") String platform, MovieService movieService, PlatziPlayAiService aiService) {
        this.movieService = movieService;
        this.aiService = aiService;
        this.platform = platform;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll(){
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a movie by id",
            description = "Returns movie that match with id sending",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Movie found"),
                    @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content)
            }
    )
    public ResponseEntity<MovieDto> getById(@Parameter(description = "Identificador de la pelicua a recuperar", example = "9") @PathVariable long id){
        MovieDto movieDto = this.movieService.getById(id);
        return movieDto != null? ResponseEntity.ok(movieDto):ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.save(movieDto));
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generateMoviesSuggestion(@RequestBody SuggestRequestDto suggestRequestDto){
        return ResponseEntity.ok(this.aiService.generateMovieSuggestion(suggestRequestDto.userPreference(), platform));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable long id, @RequestBody @Valid UpdateMovieDto updateMovieDto){
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        return this.movieService.delete(id)? ResponseEntity.noContent().build(): ResponseEntity.notFound().build();
    }
}
