package restorder.orderproduk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.ProductImage;

import java.util.Optional;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    Optional<ProductImage> findByName(String fileName);
}
