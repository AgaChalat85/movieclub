package pl.agachalat.movieclub.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.agachalat.movieclub.domain.movie.Movie;
import pl.agachalat.movieclub.dto.MovieDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(source = "genre.name", target = "genre")
    MovieDto mapToMovieDto(Movie movie);

    @Mapping(source = "genre", target = "genre.name")
    Movie mapToMovie(MovieDto movieDto);

    List<MovieDto> mapToMovieDtoList(List<Movie> movies);
}
