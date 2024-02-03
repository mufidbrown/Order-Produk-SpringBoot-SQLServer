package restorder.orderproduk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.Order;
import restorder.orderproduk.entity.User;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByUser(User user);

    List<Order> findOrdersByUser(User user);

    public Long countById(Long id);

}
