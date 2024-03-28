package restorder.orderproduk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.Pegawai;

public interface PegawaiRepository extends JpaRepository<Pegawai, Long> {
}
