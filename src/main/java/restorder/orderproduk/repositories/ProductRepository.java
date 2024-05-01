package restorder.orderproduk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
