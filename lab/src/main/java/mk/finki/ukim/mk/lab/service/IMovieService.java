package mk.finki.ukim.mk.lab.service;
import mk.finki.ukim.mk.lab.model.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieService {
    List<Movie> listAll();
    List<Movie> searchMovies(String text, double rating);

    void deleteById(Long id);

    Movie addMovie(Long movieId,String title, String summary, Double rating, Long productionId);

    public Optional<Movie> findMovieById(Long id);
}
