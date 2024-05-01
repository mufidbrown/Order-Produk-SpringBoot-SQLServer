package restorder.orderproduk.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    private String alamat;

    private String email;

    private String telepon;

    private String password;


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getAlamat() {
//        return alamat;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getTelepon() {
//        return telepon;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setAlamat(String alamat) {
//        this.alamat = alamat;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setTelepon(String telepon) {
//        this.telepon = telepon;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }


}
