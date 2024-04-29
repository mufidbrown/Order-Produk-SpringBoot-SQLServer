package restorder.orderproduk.entity;


import javax.persistence.*;

@Entity
@Table(name = "pegawais")
public class Pegawai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pegawai;

    private String nik;

    private String nama;

    private String jabatan;

    private String alamat;

    private String email;

    private String telepon;

    public Long getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(Long id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}
