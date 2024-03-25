package restorder.orderproduk.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Order extends TimestampedEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    String trackingNumber;

//    @Enumerated
//    OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Address address;

//     TODO: think more about consequence of cascade remove ... not sure
//     It is mapped by OrderItem:: "order"

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    Collection<OrderItem> orderItems;

    // @Type(type = "org.hibernate.type.NumericBooleanType")
    // @Column(name = "delivered", nullable = false)
    // private Boolean delivered = false;

    @Transient
    double total;

    @Transient
    private Long orderItemsCount;



}
