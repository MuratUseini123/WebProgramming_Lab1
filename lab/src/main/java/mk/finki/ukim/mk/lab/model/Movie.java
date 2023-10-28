package mk.finki.ukim.mk.lab.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
    private String title;
    private String summary;
    private double rating;
}
