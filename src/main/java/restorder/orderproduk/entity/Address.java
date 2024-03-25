package restorder.orderproduk.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "addresses")
public class Address extends TimestampedEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public String streetAddress;
    private String city;
    private String country;
    private String zipCode;
    private String firstName;
    private String lastName;

}
