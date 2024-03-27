package restorder.orderproduk.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Long> {

}
