package movies;

import movies.model.Movie;
import movies.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class MovieTrackerSpringBootApplicationTests {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieTrackerSpringBootApplicationTests(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Test
    void givenCreateMovieWhenFindAllMovieThenExpectOneMovie() {
        Movie movie = new Movie.MovieBuilder()
                .setNameBuilder("Avatar1 (2009)")
                .setCategoryBuilder("Science fiction")
                .setRatingBuilder(4)
                .setDescriptionBuilder("A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn " +
                        "between following his orders and protecting the world he feels is his home.").build();
        movieRepository.save(movie);
        assertThat(Arrays.asList(movieRepository.findAll()).size()).isEqualTo(1);
    }
}
