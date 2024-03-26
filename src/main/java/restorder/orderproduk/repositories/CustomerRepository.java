package restorder.orderproduk.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
