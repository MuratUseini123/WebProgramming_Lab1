package mk.finki.ukim.mk.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {
    private List<Movie> movies;

    @PostConstruct
    public void init(){
        this.movies = new ArrayList<>();
        Movie midnightShadows = new Movie("Midnight Shadows", "A thrilling mystery unfolds under the cover of darkness.", 4);
        movies.add(midnightShadows);

        Movie lostInTime = new Movie("Lost in Time", "A time-travel adventure that blurs the line between past and present.", 3);
        movies.add(lostInTime);

        Movie whispersOfTheForest = new Movie("Whispers of the Forest", "An enchanting tale of magic and nature's secrets.", 4);
        movies.add(whispersOfTheForest);

        Movie cyberCityChronicles = new Movie("Cyber City Chronicles", "A dystopian future where technology rules and rebels rise.", 4);
        movies.add(cyberCityChronicles);

        Movie theHauntingHour = new Movie("The Haunting Hour", "A chilling horror story that will send shivers down your spine.", 5);
        movies.add(theHauntingHour);

        Movie islandOfDreams = new Movie("Island of Dreams", "An epic adventure to a mysterious island with hidden treasures.", 3);
        movies.add(islandOfDreams);

        Movie stellarOdyssey = new Movie("Stellar Odyssey", "A space exploration journey to distant galaxies.", 4);
        movies.add(stellarOdyssey);

        Movie theEnchantedMirror = new Movie("The Enchanted Mirror", "A magical mirror reveals unexpected secrets and adventures.", 4);
        movies.add(theEnchantedMirror);

        Movie secretsOfTheDeep = new Movie("Secrets of the Deep", "An underwater expedition to unlock the mysteries of the ocean.", 3);
        movies.add(secretsOfTheDeep);

        Movie cityOfIntrigue = new Movie("City of Intrigue", "In a city filled with secrets, a detective must unravel the truth.", 4);
        movies.add(cityOfIntrigue);
    }

    public List<Movie> findAll() {
        return this.movies;
    }

    public List<Movie> searchMovies(String searchParam, double rating){
        return movies
                .stream()
                .filter(movie ->
                        (movie.getTitle().contains(searchParam) || movie.getSummary().contains(searchParam))
                        && (movie.getRating() >= rating)
                )
                .collect(Collectors.toList());
    }

    public void addMovie(Movie newMovie){
        this.movies.add(newMovie);
    }

}
