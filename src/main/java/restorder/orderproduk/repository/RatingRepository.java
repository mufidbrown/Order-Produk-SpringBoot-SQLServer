package restorder.orderproduk.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {


}
