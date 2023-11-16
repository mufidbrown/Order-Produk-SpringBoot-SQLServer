package restorder.orderproduk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.FileDB;

public interface FileDBRepository extends JpaRepository<FileDB, String> {
}
