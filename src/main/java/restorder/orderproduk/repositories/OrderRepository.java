package restorder.orderproduk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}