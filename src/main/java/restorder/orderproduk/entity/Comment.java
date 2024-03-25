package restorder.orderproduk.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
@Entity
@Builder
public class Comment extends TimestampedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") // not required
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id") // not required
    private Product product;

    private Integer rating;

}
