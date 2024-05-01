package restorder.orderproduk.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String alamat;
    private String email;
    private String telepon;
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

//
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
