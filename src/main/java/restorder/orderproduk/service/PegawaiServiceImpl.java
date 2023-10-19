package restorder.orderproduk.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restorder.orderproduk.BaseResponse;
import restorder.orderproduk.entity.Pegawai;
import restorder.orderproduk.model.PegawaiResponse;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PegawaiServiceImpl implements ServicePegawai {


    private final EntityManager entityManager;



    @Override
    public BaseResponse<?> test() {
        Query query = entityManager.createNativeQuery("SELECT nik, nama, alamat, email, jabatan, telepon  from pegawais p WHERE id_pegawai = 11");
        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
        PegawaiResponse pegawaiResponse = PegawaiResponse.builder()
                .nik(list.get(0).toString())
                .nama(list.get(1).toString())
                .jabatan(list.get(2).toString())
                .alamat(list.get(3).toString())
                .email(list.get(4).toString())
                .telepon(list.get(5).toString())
                .build();
        return BaseResponse.ok(pegawaiResponse);

        // PegawaiServiceImpl di panggil/test tahap akhir di TestPegawaiController
    }
}
