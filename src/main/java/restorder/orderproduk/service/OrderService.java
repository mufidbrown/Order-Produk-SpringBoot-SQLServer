package restorder.orderproduk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restorder.orderproduk.entity.Order;
import restorder.orderproduk.repositories.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    public Order updateOrder(Long id, Order order) {
        orderRepository.save(order);
        return order;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
