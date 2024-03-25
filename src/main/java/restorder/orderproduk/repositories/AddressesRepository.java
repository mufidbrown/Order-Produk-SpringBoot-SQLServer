package restorder.orderproduk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restorder.orderproduk.entity.Address;

import java.util.List;

@Repository
public interface AddressesRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserId(Long userId);
}
