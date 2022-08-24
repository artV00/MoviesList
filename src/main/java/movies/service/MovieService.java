package movies.service;

import movies.model.Movie;

import java.util.Optional;

public interface MovieService {

    Movie createMovie(Movie movie);

    Optional<Movie> findMovieById(Long movieId);

    Iterable<Movie> findAllMovies();

    Movie updateMovie(Movie movie);

    void deleteMovieById(Long movieId);
}
