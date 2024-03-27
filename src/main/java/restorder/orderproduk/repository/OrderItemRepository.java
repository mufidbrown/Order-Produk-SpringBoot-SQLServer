package restorder.orderproduk.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
