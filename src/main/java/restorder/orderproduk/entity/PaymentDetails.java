package restorder.orderproduk.entity;


import jakarta.persistence.*;
import lombok.*;
import restorder.orderproduk.enums.PaymentMethod;
import restorder.orderproduk.enums.PaymentStatus;

@Entity
//@Table(name = "paymentdetails")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PaymentMethod paymentMethod;
    private PaymentStatus status;
    private String paymentId;



}
