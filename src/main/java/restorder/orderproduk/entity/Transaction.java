package restorder.orderproduk.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "id_users")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "id_products")
//    private Product product;


    private LocalDateTime transactionDate;
}
