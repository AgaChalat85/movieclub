package pl.agachalat.movieclub.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.agachalat.movieclub.domain.genre.Genre;
import pl.agachalat.movieclub.domain.movie.Movie;
import pl.agachalat.movieclub.dto.MovieDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("dev")
public class MovieMapperTest {

    @Autowired
    private MovieMapper movieMapper;

    @Test
    void mapToMovieDto() {
        //Given
        Genre genre = new Genre(8L, "Fantasy" );
        Movie movie = new Movie(1L, "Zombie Apocalypse", "Nadine", 1992, genre, true );
        //When
        MovieDto movieDto = movieMapper.mapToMovieDto(movie);
        //Then
        assertEquals(1L, movieDto.getId());
        assertEquals("Zombie Apocalypse", movieDto.getTitle());
        assertEquals("Nadine", movieDto.getOriginalTitle());
        assertEquals(1992, movieDto.getReleaseYear());
        assertEquals("Fantasy", movieDto.getGenre());
        assertEquals(true, movieDto.isPromoted());
    }

    @Test
    void mapToMovie() {
        //Given
        MovieDto movieDto = new MovieDto(1L, "Twentieth Century", "21 Jump Street", 2007, "Comedy", false);
        //When
        Movie movie= movieMapper.mapToMovie(movieDto);
        //Then
        assertEquals(1L, movieDto.getId());
        assertEquals("Twentieth Century", movie.getTitle());
        assertEquals("21 Jump Street", movie.getOriginalTitle());
        assertEquals(2007, movie.getReleaseYear());
        assertEquals("Comedy", movie.getGenre().getName());
        assertEquals(false, movie.isPromoted());
    }
}
