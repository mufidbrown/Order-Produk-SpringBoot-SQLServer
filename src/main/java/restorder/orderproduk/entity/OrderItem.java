package restorder.orderproduk.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "order_items")
public class OrderItem extends TimestampedEntity{

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // One order item points to one product, one product points to many order items(may be ordered by many different users)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private String slug;
    private String productName;
    private double price;
    private int quantity;

}
