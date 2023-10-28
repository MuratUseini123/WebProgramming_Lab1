package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.repository.MovieRepository;
import mk.finki.ukim.mk.lab.service.IMovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public List<Movie> listAll() {
        return this.movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text, double rating) {
        return this.movieRepository.searchMovies(text, rating);
    }
}
