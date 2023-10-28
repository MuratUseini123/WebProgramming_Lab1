package mk.finki.ukim.mk.lab.repository;


import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.TicketOrder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TickerOrderRepository {
    private List<TicketOrder> tickerOrders;

    @PostConstruct
    public void initTickerOrders(){
        this.tickerOrders = new ArrayList<>();
    }

    public TicketOrder createOrder(String movieTitle, String clientName, String address, int numberOfTickets){
        TicketOrder newOrder = new TicketOrder(movieTitle,clientName, address, Long.valueOf(numberOfTickets));
        this.tickerOrders.add(newOrder);
        return newOrder;
    }
}
