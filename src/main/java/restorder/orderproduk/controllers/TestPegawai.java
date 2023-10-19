package restorder.orderproduk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import restorder.orderproduk.BaseResponse;
import restorder.orderproduk.service.ServicePegawai;

@RestController
public class TestPegawai {

    @Autowired
    private ServicePegawai servicePegawai;

    @GetMapping("/test")
    public BaseResponse<?> test(){
        return servicePegawai.test();
    }

}
