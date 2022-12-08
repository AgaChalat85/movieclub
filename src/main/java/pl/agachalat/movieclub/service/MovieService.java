package pl.agachalat.movieclub.service;

import org.springframework.stereotype.Service;
import pl.agachalat.movieclub.domain.movie.Movie;
import pl.agachalat.movieclub.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAllPromotedMovies() {
        return movieRepository.findAllByPromotedIsTrue();
    }
}
