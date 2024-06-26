package restorder.orderproduk.logging.entity;

import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity class representing a {@link LogEntity} entry in the database.
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_produk_log")
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String message;

    private String endpoint;

    private String method;

    @Enumerated(EnumType.STRING)
    private HttpStatus status;

    private String userInfo;

    private String errorType;

    @Column(columnDefinition = "TEXT")
    private String response;

    private String operation;

    private LocalDateTime time;
}
