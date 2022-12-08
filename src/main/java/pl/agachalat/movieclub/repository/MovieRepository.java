package pl.agachalat.movieclub.repository;

import org.springframework.data.repository.CrudRepository;
import pl.agachalat.movieclub.domain.movie.Movie;

import java.util.List;

public interface MovieRepository extends CrudRepository <Movie, Long> {

    List<Movie> findAllByPromotedIsTrue();


}
