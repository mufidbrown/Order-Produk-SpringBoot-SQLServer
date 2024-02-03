package restorder.orderproduk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.Keranjang;

public interface KeranjangRepository extends JpaRepository<Keranjang, Long> {
}
