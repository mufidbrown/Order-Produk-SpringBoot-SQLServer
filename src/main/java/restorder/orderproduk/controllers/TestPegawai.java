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



//    @GetMapping("/test/v1/{id_pegawai}")
//    public BaseResponse<?> testParameter(@PathVariable Integer id_pegawai) {
//        if (id_pegawai == null) {
//            return servicePegawai.testParameter("Data tidak ada");
//        } else {
//            return servicePegawai.testParameter(id_pegawai);
//        }
//        if (id_pegawai == ) {
//            throw new IllegalArgumentException("Parameter Id_Pegawai kosong");
//            return servicePegawai.testParameter(boolean, "Parameter id_pegawai kosong", boolean);
//            throw new RuntimeException("Internal error occurred.");


//            return servicePegawai.testParameter(id_pegawai);
//        }else if(id_pegawai != null) {
//            throw new IllegalArgumentException("Parameter Id_Pegawai kosong");
//            return new BaseResponse<>(false, "Parameter Id_Pegawai kosong", null);

//        } else {
//            return servicePegawai.testParameter(id_pegawai);

//            throw new IllegalArgumentException("Parameter Id_Pegawai kosong");

//            return servicePegawai.testParameter(false, "Parameter id_pegawai kosong", null);

        }

//        if (id_pegawai != null) {
//            return servicePegawai.testParameter(id_pegawai);<>(updatedProduct, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

//    }

//    @GetMapping("/test/v1/{id_pegawai}")
//    public BaseResponse<?> testParameter(@PathVariable Integer id_pegawai) {
//        if (id_pegawai != null) {
//            return servicePegawai.testParameter(id_pegawai);
//        } else {
//            return servicePegawai.testParameter(Integer.valueOf("Pegawai Tidak Ditemukan"));
//        }
//    }




