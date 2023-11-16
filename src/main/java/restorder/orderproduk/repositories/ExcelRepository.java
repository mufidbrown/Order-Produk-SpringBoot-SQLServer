package restorder.orderproduk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.Excel;

public interface ExcelRepository extends JpaRepository<Excel, Long> {
}
