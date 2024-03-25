package restorder.orderproduk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restorder.orderproduk.entity.Order;

@Repository
public interface OrdersRepository  extends JpaRepository<Order, Long> {
}
