//package mk.finki.ukim.mk.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.model.Movie;
//import mk.finki.ukim.mk.lab.service.IMovieService;
//import mk.finki.ukim.mk.lab.service.ITickerOrderService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(urlPatterns = "servlet/movies/search")
//public class CustomMovieListServlet extends HttpServlet {
//    private final SpringTemplateEngine springTemplateEngine;
//
//    private final IMovieService movieService;
//    protected final ITickerOrderService tickerOrderService;
//
//    public CustomMovieListServlet(SpringTemplateEngine springTemplateEngine, IMovieService movieService, ITickerOrderService tickerOrderService) {
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
//
//
//        String searchParam = req.getParameter("searchParam");
//        double minRating = 0;
//        if(req.getParameter("minRating").isEmpty()){
//            minRating = 1.0;
//        }else {
//            minRating = Double.parseDouble(req.getParameter("minRating"));
//        }
//
//        context.setVariable("movies", movieService.searchMovies(searchParam, minRating));
//        context.setVariable("ticketOrders", tickerOrderService.allOrders());
//        springTemplateEngine.process(
//                "listMovies.html",
//                context,
//                resp.getWriter()
//        );
//    }
//}
//
//
