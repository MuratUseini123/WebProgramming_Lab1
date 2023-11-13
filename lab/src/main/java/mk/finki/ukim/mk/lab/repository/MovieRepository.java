package mk.finki.ukim.mk.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.bootsrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.model.Production;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public Movie save(Long movieId,String title, String summary, Double rating, Long productionId) {
        Optional<Movie> movie = this.findById(movieId);
        if (movieId == null) {
            Production p = DataHolder.productions.stream()
                    .filter(production -> production.getId().equals(productionId))
                    .findFirst().get();
            Movie newMovie = new Movie(title, summary, rating, p);
            addMovie(newMovie);
            return newMovie;
        } else {
            Optional<Movie> optionalMovie = this.findById(movieId);
            if (optionalMovie.isPresent()) {
                Movie existingMovie = optionalMovie.get();
                if (title != null && !title.equals(existingMovie.getTitle())) {
                    existingMovie.setTitle(title);
                }

                if (summary != null && !summary.equals(existingMovie.getSummary())) {
                    existingMovie.setSummary(summary);
                }

                if (rating != null && !rating.equals(existingMovie.getRating())) {
                    existingMovie.setRating(rating);
                }

                if (productionId != null) {
                    Production p = DataHolder.productions.stream()
                            .filter(production -> production.getId().equals(productionId))
                            .findFirst().get();
                    existingMovie.setProduction(p);
                }
                return existingMovie;
            } else {
                throw new IllegalArgumentException("Movie with ID " + movieId + " not found.");
            }
        }
    }

    public Optional<Movie> findById(Long id) {
        return DataHolder.movies.stream().filter(i -> i.getId().equals(id)).findFirst();
    }


}
