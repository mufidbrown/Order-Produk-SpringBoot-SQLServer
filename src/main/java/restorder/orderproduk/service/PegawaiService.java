package restorder.orderproduk.service;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restorder.orderproduk.entity.Pegawai;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.repositories.PegawaiRepository;
import restorder.orderproduk.repositories.ProductRepository;

import java.util.List;

@Service
public class PegawaiService {

    @Autowired
    private PegawaiRepository pegawaiRepository;
    public List<Pegawai> getAllPegawai() {
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



}
