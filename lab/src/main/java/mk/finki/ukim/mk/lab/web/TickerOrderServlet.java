package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.TicketOrder;
import mk.finki.ukim.mk.lab.service.ITickerOrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/ticket-order")
public class TickerOrderServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    protected final ITickerOrderService tickerOrderService;

    public TickerOrderServlet(SpringTemplateEngine springTemplateEngine, ITickerOrderService tickerOrderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.tickerOrderService = tickerOrderService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context =  new WebContext(webExchange);
        context.setVariable("selectedMovie", req.getParameter("selectedMovie"));
        context.setVariable("numberOfTickets", req.getParameter("numTickets").toString());
        context.setVariable("userName", req.getParameter("userName"));
        context.setVariable("userAddress", "localhost:8080");

        springTemplateEngine.process(
                "orderConfirmation.html",
                context,
                resp.getWriter()
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.tickerOrderService.placeOrder(
                req.getParameter("selectedMovie"),
                req.getParameter("userName"),
                req.getParameter("userAddress"),
                Integer.parseInt(req.getParameter("numberOfTickets"))
                );
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
