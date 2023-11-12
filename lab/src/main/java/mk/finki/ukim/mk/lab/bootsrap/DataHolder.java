package mk.finki.ukim.mk.lab.bootsrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.model.Production;
import mk.finki.ukim.mk.lab.model.TicketOrder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Movie> movies;
    public static List<Production> productions;

    public static List<TicketOrder> tickerOrders;

    public static Long ProdIdCount;
    public static Long MovieIdCount;

    @PostConstruct
    public void init(){
        ProdIdCount = Long.valueOf(1);
        MovieIdCount = Long.valueOf(1);
        movies = new ArrayList<>();
        movies.add(new Movie("Midnight Shadows", "A thrilling mystery unfolds under the cover of darkness.", 4,null));
        movies.add(new Movie("Lost in Time", "A time-travel adventure that blurs the line between past and present.", 3,null));
        movies.add(new Movie("Whispers of the Forest", "An enchanting tale of magic and nature's secrets.", 4,null));
        movies.add(new Movie("Cyber City Chronicles", "A dystopian future where technology rules and rebels rise.", 4,null));
        movies.add(new Movie("The Haunting Hour", "A chilling horror story that will send shivers down your spine.", 5,null));
        movies.add(new Movie("Island of Dreams", "An epic adventure to a mysterious island with hidden treasures.", 3,null));
        movies.add(new Movie("Stellar Odyssey", "A space exploration journey to distant galaxies.", 4,null));
        movies.add(new Movie("The Enchanted Mirror", "A magical mirror reveals unexpected secrets and adventures.", 4,null));
        movies.add(new Movie("Secrets of the Deep", "An underwater expedition to unlock the mysteries of the ocean.", 3,null));
        movies.add(new Movie("City of Intrigue", "In a city filled with secrets, a detective must unravel the truth.", 4,null));

        productions = new ArrayList<>();
        productions.add(new Production("alfa", "usa", "addressOne"));
        productions.add(new Production("beta", "canada", "addressTwo"));
        productions.add(new Production("gamma", "uk", "addressThree"));
        productions.add(new Production("delta", "australia", "addressFour"));
        productions.add(new Production("epsilon", "germany", "addressFive"));

        tickerOrders = new ArrayList<>();

        for (var movie:movies) {
            int randomNum = (int)(Math.random()*5);
            movie.setProduction(productions.get(randomNum));
        }
    }
}
