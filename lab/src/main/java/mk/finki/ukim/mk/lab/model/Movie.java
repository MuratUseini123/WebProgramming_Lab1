package mk.finki.ukim.mk.lab.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import mk.finki.ukim.mk.lab.bootsrap.DataHolder;

@Data
public class Movie {
    private Long id;
    private String title;
    private String summary;
    private double rating;
    private Production production;

    public Movie(String title, String summary, double rating, Production production) {
        this.id = DataHolder.MovieIdCount;
        this.title = title;
        this.summary = summary;
        this.rating = rating;
        this.production = production;
        DataHolder.MovieIdCount+=1;
    }
}
