package restorder.orderproduk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.CartItem;


public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
