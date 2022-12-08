package pl.agachalat.movieclub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.agachalat.movieclub.domain.movie.Movie;
import pl.agachalat.movieclub.dto.MovieDto;
import pl.agachalat.movieclub.mapper.MovieMapper;
import pl.agachalat.movieclub.service.MovieService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/movies")
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getALLPromotedMovies() {
        List<Movie> movies = movieService.findAllPromotedMovies();
        return ResponseEntity.ok(movieMapper.mapToMovieDtoList(movies));
    }
}
