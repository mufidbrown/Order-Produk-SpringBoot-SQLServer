package restorder.orderproduk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
