package restorder.orderproduk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import restorder.orderproduk.BaseResponse;
import restorder.orderproduk.service.ServicePegawai;

@RestController
public class TestPegawai {

    @Autowired
    private ServicePegawai servicePegawai;

    @GetMapping("/test")
    public BaseResponse<?> test() {
        return servicePegawai.test();
    }

    @GetMapping("/test/v1/{id_pegawai}")
    public BaseResponse<?> testParameter(@PathVariable Integer id_pegawai){
        return servicePegawai.testParameter(id_pegawai);
    }

}






