package mk.finki.ukim.mk.lab.controller;

import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.model.Production;
import mk.finki.ukim.mk.lab.service.implementation.MovieService;
import mk.finki.ukim.mk.lab.service.implementation.ProductionService;
import mk.finki.ukim.mk.lab.service.implementation.TicketOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final TicketOrderService ticketOrderService;

    private final ProductionService productionService;

    public MovieController(MovieService movieService, TicketOrderService ticketOrderService, ProductionService productionService) {
        this.movieService = movieService;
        this.ticketOrderService = ticketOrderService;
        this.productionService = productionService;
    }

    @GetMapping
    public String getMoviesPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Movie> movieList = this.movieService.listAll();
        model.addAttribute("movies", movieList);
        model.addAttribute("ticketOrders", ticketOrderService.allOrders());
        return "listMovies";

    }

    @GetMapping("/search")
    public String searchMovies(@RequestParam String searchParam,
                               @RequestParam(defaultValue = "1.0") double minRating,
                               Model model) {

        model.addAttribute("movies", movieService.searchMovies(searchParam, minRating));
        model.addAttribute("ticketOrders", ticketOrderService.allOrders());
        return "listMovies";
    }

    @GetMapping("/add-form")
    public String addMoviePage(Model model) {
        List<Production> productions = this.productionService.findAll();
        model.addAttribute("productions", productions);
        return "add-movie";
    }

    @PostMapping("/add")
    public String addMovie(@RequestParam String title,
                         @RequestParam String summary,
                         @RequestParam Double rating,
                         @RequestParam Long production){

        this.movieService.addMovie(title, summary, rating, production);
        return "redirect:/movies";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.movieService.deleteById(id);
        return "redirect:/movies";
    }

}
