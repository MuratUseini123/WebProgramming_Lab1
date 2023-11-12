package mk.finki.ukim.mk.lab.service;
import mk.finki.ukim.mk.lab.model.TicketOrder;

import java.util.List;


public interface ITickerOrderService {
    TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets);

    List<TicketOrder> allOrders();

}
