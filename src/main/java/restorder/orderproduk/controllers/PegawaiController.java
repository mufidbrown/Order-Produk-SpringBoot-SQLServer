package restorder.orderproduk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restorder.orderproduk.BaseResponse;
import restorder.orderproduk.entity.Pegawai;
import restorder.orderproduk.service.PegawaiService;

import java.util.List;

@RestController
@RequestMapping("/api/pegawais")
public class PegawaiController {


    @Autowired
    private PegawaiService pegawaiService;



    @GetMapping
    public ResponseEntity<List<Pegawai>> getAllPegawais() {
        List<Pegawai> pegawais = pegawaiService.getAllPegawais();
        return new ResponseEntity<>(pegawais, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pegawai> getPegawaiById(@PathVariable Long id) {
        Pegawai pegawai = pegawaiService.getPegawaiById(id);
        if (pegawai != null) {
            return new ResponseEntity<>(pegawai, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Pegawai> createPegawai(@RequestBody Pegawai pegawai) {
        Pegawai createdPegawai = pegawaiService.createPegawai(pegawai);
        return new ResponseEntity<>(createdPegawai, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Pegawai> updatePegawai(@PathVariable Long id, @RequestBody Pegawai pegawai) {
        Pegawai updatedPegawai = pegawaiService.updatePegawai(id, pegawai);
        if (updatedPegawai != null) {
            return new ResponseEntity<>(updatedPegawai, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePegawai(@PathVariable Long id) {
        pegawaiService.deletePegawai(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





//-----------------------BaseResponse------------------------

    @GetMapping("/pegawai/v1")
    public ResponseEntity<BaseResponse<List<Pegawai>>> getAllPegawais2() {
        List<Pegawai> pegawais = pegawaiService.getAllPegawais();
        return ResponseEntity.ok(BaseResponse.ok("Daftar Semua Pegawai", pegawais));

    }

//    @GetMapping
//    public ResponseEntity<BaseResponse<List<Person>>> getAllPersons() {
//        List<Person> persons = getAllPersonsFromDatabase(); // Replace with your data retrieval logic
//        return ResponseEntity.ok(BaseResponse.success("All persons retrieved", persons));
//    }



    @GetMapping("/pegawai/v1/{id}")
    public ResponseEntity<BaseResponse<Pegawai>> getPegawaiById2(@PathVariable("id") Long id) {
        Pegawai pegawai = pegawaiService.getPegawaiById(id);
        if (pegawai != null) {
            return ResponseEntity.ok(BaseResponse.ok("Pegawai Ditemukan", pegawai));
        } else {
            return ResponseEntity.ok(BaseResponse.error("Pegawai Tidak Ditemukan"));
        }
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<BaseResponse<Person>> getPersonById(@PathVariable Long id) {
//        Person person = findPersonById(id);
//
//        if (person != null) {
//            return ResponseEntity.ok(BaseResponse.success("Person found", person));
//        } else {
//            return ResponseEntity.ok(BaseResponse.error("Person not found"));
//        }
//    }


//    @GetMapping
//    public BaseResponse<List<Pegawai>> getAllPegawais2(@RequestParam(required = false) String title) {
//        try {
//            List<Pegawai> pegawais = new ArrayList< ~ > ();
//            if (nama == null)
//                pegawaiRepository.findAll().forEach(pegawais::add);
//            else
//                pegawaiRepository.findBy()
//
//                return new ResponseEntity<>(pegawais, HttpStatus.OK);
//        }
//
//    }

//    @GetMapping
//    public ResponseEntity<BaseResponse<List<Pegawai>>> getAllPegawais() {
//        List<Pegawai> pegawais = getAllPegawaisFromDataSource(); // Implement this method
//
//        if (!pegawais.isEmpty()) {
//            return ResponseEntity.ok(new BaseResponse<>(200, "Success", pegawais));
//        } else {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new BaseResponse<>(204, "No persons found", null));
//        }
//    }
//
//    private List<Pegawai> getAllPegawaisFromDataSource() {
//        return null;
//    }
//
//

//    @GetMapping
//    public ResponseEntity<List<Pegawai>> getAllPegawais() {
//        List<Pegawai> pegawais = pegawaiService.getAllPegawais();
//        return new ResponseEntity<>(pegawais, HttpStatus.OK);
//    }
//    @GetMapping("/pegawais/v1/{id}")
//    public BaseResponse<Optional<Pegawai>> getPegawaiById2(@PathVariable Long id) {
//        Optional<Pegawai> PegawaisData = pegawaiRepository.findById("id_pegawai") long id);
//
//        if (PegawaisData.isEmpty()) {
//            return BaseResponse.error("data kosong");
//        } else {
//            return BaseResponse.ok(PegawaisData);
//        }
//    }




}




