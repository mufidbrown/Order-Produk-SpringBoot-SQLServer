package restorder.orderproduk.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import restorder.orderproduk.entity.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}
