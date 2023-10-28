package mk.finki.ukim.mk.lab.service;
import mk.finki.ukim.mk.lab.model.TicketOrder;


public interface ITickerOrderService {
    TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets);

}
