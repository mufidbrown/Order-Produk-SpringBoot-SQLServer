package restorder.orderproduk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import restorder.orderproduk.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
