package mk.finki.ukim.mk.lab.controller;

import mk.finki.ukim.mk.lab.service.ITickerOrderService;
import mk.finki.ukim.mk.lab.service.implementation.TicketOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ticket-order")
public class TicketOrderController {

    private final TicketOrderService tickerOrderService;

    public TicketOrderController(TicketOrderService tickerOrderService) {
        this.tickerOrderService = tickerOrderService;
    }

    @GetMapping
    public String showTicketOrderConfirmation(@RequestParam(required = false) String error,
                                              @RequestParam String selectedMovie,
                                              @RequestParam String numTickets,
                                              @RequestParam String userName,
                                              Model model) {

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("selectedMovie", selectedMovie);
        model.addAttribute("numberOfTickets", numTickets);
        model.addAttribute("userName", userName);
        model.addAttribute("userAddress", "localhost:8080");

        return "orderConfirmation";
    }

    @PostMapping
    public String placeTicketOrder(@RequestParam String selectedMovie,
                                   @RequestParam String userName,
                                   @RequestParam String userAddress,
                                   @RequestParam int numberOfTickets) {

        this.tickerOrderService.placeOrder(selectedMovie, userName, userAddress, numberOfTickets);
        return "redirect:/movies";
    }
}