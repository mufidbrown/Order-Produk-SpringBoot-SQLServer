package restorder.orderproduk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")

public class Transaction {

    @Id
    @Column(name = "id_transaction")
    private Long id_transaction;

    @Id
    @Column(name = "id")
    private Long id_users;

    @Id
    private Long id;

}
