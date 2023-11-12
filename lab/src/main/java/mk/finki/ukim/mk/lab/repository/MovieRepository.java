package mk.finki.ukim.mk.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.bootsrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.model.Production;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {
    public List<Movie> findAll() {
        return DataHolder.movies;
    }
    public List<Movie> searchMovies(String searchParam, double rating){
        return DataHolder.movies
                .stream()
                .filter(movie ->
                        (movie.getTitle().contains(searchParam) || movie.getSummary().contains(searchParam))
                        && (movie.getRating() >= rating)
                )
                .collect(Collectors.toList());
    }
    public void addMovie(Movie newMovie){
        DataHolder.movies.add(newMovie);
    }

    public void delete(Long Id){
        DataHolder.movies.removeIf(i -> i.getId().equals(Id));
    }

    public Movie add(String title, String summary, Double rating, Long productionId) {
        Production p = DataHolder.productions.stream()
                .filter(production -> production.getId().equals(productionId))
                .findFirst().get();
        Movie movie = new Movie(title, summary, rating, p);
        addMovie(movie);
        return movie;
    }

}
