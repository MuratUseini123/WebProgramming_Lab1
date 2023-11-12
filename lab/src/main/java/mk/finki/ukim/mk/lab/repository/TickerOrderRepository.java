package mk.finki.ukim.mk.lab.repository;


import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.bootsrap.DataHolder;
import mk.finki.ukim.mk.lab.model.TicketOrder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TickerOrderRepository {

    public TicketOrder createOrder(String movieTitle, String clientName, String address, int numberOfTickets){
        TicketOrder newOrder = new TicketOrder(movieTitle,clientName, address, Long.valueOf(numberOfTickets));
        DataHolder.tickerOrders.add(newOrder);
        return newOrder;
    }

    public List<TicketOrder> getAllOrders(){
        return DataHolder.tickerOrders;
    }
}
