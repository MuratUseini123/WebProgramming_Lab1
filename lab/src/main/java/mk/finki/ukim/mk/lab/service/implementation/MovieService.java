package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.repository.MovieRepository;
import mk.finki.ukim.mk.lab.service.IMovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void deleteById(Long id){
        this.movieRepository.delete(id);
    }

    @Override
    public Movie addMovie(Long movieId,String title, String summary, Double rating, Long productionId) {
        return this.movieRepository.save(movieId,title, summary, rating, productionId);
    }

    @Override
    public Optional<Movie> findMovieById(Long id) {
        return this.movieRepository.findById(id);
    }

}
