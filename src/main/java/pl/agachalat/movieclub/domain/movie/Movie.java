package pl.agachalat.movieclub.domain.movie;

import lombok.Data;
import pl.agachalat.movieclub.domain.genre.Genre;

import javax.persistence.*;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String originalTitle;
    private Integer releaseYear;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;
    private boolean promoted;
}
