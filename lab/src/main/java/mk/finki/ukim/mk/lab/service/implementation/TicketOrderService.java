package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.TicketOrder;
import mk.finki.ukim.mk.lab.repository.TickerOrderRepository;
import mk.finki.ukim.mk.lab.service.ITickerOrderService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketOrderService implements ITickerOrderService {

    private final TickerOrderRepository orderRepository;

    public TicketOrderService(TickerOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets) {
        TicketOrder order = this.orderRepository.createOrder(movieTitle, clientName, address, numberOfTickets);
        System.out.println(order.toString());
        return order;
    }

    @Override
    public List<TicketOrder> allOrders() {
        return this.orderRepository.getAllOrders();
    }


}
