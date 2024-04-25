package restorder.orderproduk.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import restorder.orderproduk.entity.Pegawai;
import restorder.orderproduk.service.pegawai.PegawaiService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PegawaiServiceTest {

    @Autowired
    PegawaiService pegawaiService;

    @BeforeAll
    void setUp() {
        Pegawai pegawai = new Pegawai();
        pegawai.setNama("Ilham Mufid");
        pegawai.setEmail("example@gmail.com");
        pegawai.setAlamat("Surabaya");
        pegawaiService.createPegawai(pegawai);
    }

    @Test
    void testGetAllPegawais() {
        Assertions.assertFalse(pegawaiService.getAllPegawais().isEmpty());
    }

//    @Test
//    void testGetPegawaiById() {
//        Pegawai pegawai = pegawaiService.getPegawaiById(1L).orElseThrow(EntityNotFoundException::new);
//        Assertions.assertEquals("Ilham Mufid", pegawai.getNama());
//    }


}
