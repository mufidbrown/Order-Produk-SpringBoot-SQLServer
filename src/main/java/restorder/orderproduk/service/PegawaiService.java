package restorder.orderproduk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restorder.orderproduk.BaseResponse;
import restorder.orderproduk.entity.Pegawai;
import restorder.orderproduk.repositories.PegawaiRepository;

import java.util.List;

@Service
public class PegawaiService {

    @Autowired
    private PegawaiRepository pegawaiRepository;
    public List<Pegawai> getAllPegawais() {
        return pegawaiRepository.findAll();
    }

    public Pegawai getPegawaiById(Long id){
        return pegawaiRepository.findById(id).orElse(null);
    }


    public Pegawai updatePegawai(Long id, Pegawai pegawai) {
        pegawaiRepository.save(pegawai);
        return pegawai;
    }



    public void deletePegawai(Long id) {
        pegawaiRepository.deleteById(id);
    }

    public Pegawai createPegawai(Pegawai pegawai) {
        pegawaiRepository.save(pegawai);
        return pegawai;
   }






//   BaseResponse<?> test();
//   BaseResponse<?> testPegawai();


}
