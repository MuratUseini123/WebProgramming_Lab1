package mk.finki.ukim.mk.lab.service;
import mk.finki.ukim.mk.lab.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> listAll();
    List<Movie> searchMovies(String text, double rating);

    void deleteById(Long id);

    Movie addMovie(String title, String summary, Double rating, Long productionId);
}
