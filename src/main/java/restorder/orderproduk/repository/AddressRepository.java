package restorder.orderproduk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {

}
