package restorder.orderproduk.entity;


import jakarta.persistence.*;
import lombok.*;
import restorder.orderproduk.enums.OrderStatus;

import java.time.LocalDateTime;

@Entity
//@Table(name = "orders")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="order_id")
    private String orderId;

    private LocalDateTime orderDate;

    private LocalDateTime deliveryDate;

//    @Embedded
//    private PaymentDetails paymentDetails=new PaymentDetails();

    private double totalPrice;

    private Integer totalDiscountedPrice;

    private Integer discounte;

    private OrderStatus orderStatus;

    private int totalItem;

    private LocalDateTime createdAt;

}
