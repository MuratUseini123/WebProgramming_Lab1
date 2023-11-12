//package mk.finki.ukim.mk.lab.web;
//
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.service.IMovieService;
//import mk.finki.ukim.mk.lab.service.ITickerOrderService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//
//
//
//import java.io.IOException;
//
//@WebServlet(urlPatterns = {"/servlet/movies", ""})
//public class MovieListServlet extends HttpServlet {
//
//    private final SpringTemplateEngine springTemplateEngine;
//
//    private final IMovieService movieService;
//    protected final ITickerOrderService tickerOrderService;
//
//    public MovieListServlet(SpringTemplateEngine springTemplateEngine, IMovieService movieService, ITickerOrderService tickerOrderService) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.movieService = movieService;
//        this.tickerOrderService = tickerOrderService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context =  new WebContext(webExchange);
//        context.setVariable("movies", movieService.listAll());
//        context.setVariable("ticketOrders", tickerOrderService.allOrders());
//
//        springTemplateEngine.process(
//                "listMovies.html",
//                context,
//                resp.getWriter()
//        );
//
//    }
//}
