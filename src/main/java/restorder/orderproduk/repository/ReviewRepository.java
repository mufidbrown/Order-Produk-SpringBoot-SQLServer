package restorder.orderproduk.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
