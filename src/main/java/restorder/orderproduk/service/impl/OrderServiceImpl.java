package restorder.orderproduk.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import restorder.orderproduk.entity.Keranjang;
import restorder.orderproduk.entity.Order;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.exception.OrderNotFoundException;
import restorder.orderproduk.repositories.OrderRepository;
import restorder.orderproduk.service.OrderService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public static final int ORDERS_PER_PAGE = 8;


    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getAllOrdersByUser(User user) {
        return orderRepository.findOrdersByUser(user);
    }

    @Override
    public void saveOrder(Order orders) {
        orderRepository.save(orders);
    }

    @Override
    public Order getOrder(Long id) {
        Order orders = null;
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isPresent()) orders = optional.get();
        return orders;
    }

    @Override
    public Order getOrderByUser(User user) throws OrderNotFoundException {
        Order order = orderRepository.findByUser(user);
        if (order == null) {
            throw new OrderNotFoundException("Couldn't find any orders with ID " + order.getId());
        }
        return order;
    }

    @Override
    public float countSum(List<Keranjang> keranjangs) {
        float sum = 0;
        for (Keranjang keranjang : keranjangs) {
            sum += keranjang.getSubtotal();
        }
        return sum;
    }

    @Override
    public void deleteOrder(Long id) throws OrderNotFoundException {
        Long countById = orderRepository.countById(id);
        if (countById == null || countById == 0) {
            throw new OrderNotFoundException("Couldn't find any orders with id " + id);
        }
        orderRepository.deleteById(id);
    }

    @Override
    public Page<Order> listByPage(int pageNum) {
        Pageable pageable = PageRequest.of(pageNum - 1, ORDERS_PER_PAGE);
        return orderRepository.findAll(pageable);
    }

}
