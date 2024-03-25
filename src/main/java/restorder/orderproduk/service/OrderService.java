package restorder.orderproduk.service;

import org.springframework.data.domain.Page;
import restorder.orderproduk.entity.Keranjang;
import restorder.orderproduk.entity.Order;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.exception.OrderNotFoundException;

import java.util.List;

public interface OrderService {

    public List<Order> getAllOrders();

    List<Order> getAllOrdersByUser(User user);

    public void saveOrder(Order orders);

    public Order getOrder(Long id);

    public Order getOrderByUser(User user) throws OrderNotFoundException;

    float countSum(List<Keranjang> orderBaskets);

    public void deleteOrder(Long id) throws OrderNotFoundException;


    Page<Order> listByPage(Long pageNum);

}
