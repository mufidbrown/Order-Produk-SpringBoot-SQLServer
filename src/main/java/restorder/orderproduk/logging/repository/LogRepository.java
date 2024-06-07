package restorder.orderproduk.logging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.logging.entity.LogEntity;

public interface LogRepository extends JpaRepository<LogEntity, Long> {
}
