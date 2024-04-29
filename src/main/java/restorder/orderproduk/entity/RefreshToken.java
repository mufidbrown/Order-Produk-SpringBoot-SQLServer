package restorder.orderproduk.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "RefreshToken")
@Data
public class RefreshToken  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expiryDate;
}