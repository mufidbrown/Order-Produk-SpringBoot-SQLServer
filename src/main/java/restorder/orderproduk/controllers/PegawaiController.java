package restorder.orderproduk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restorder.orderproduk.entity.Pegawai;
import restorder.orderproduk.service.PegawaiService;

import java.util.List;

@RestController
@RequestMapping("/api/pegawai")
public class PegawaiController {


    @Autowired
    private PegawaiService pegawaiService;

    @GetMapping
    public ResponseEntity<List<Pegawai>> getAllPegawais() {
        List<Pegawai> pegawais = pegawaiService.getAllPegawais();
        return new ResponseEntity<>(pegawais, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pegawai> getProductById(@PathVariable Long id) {
        Pegawai pegawai = pegawaiService.getPegawaiById(id);
        if (pegawai != null) {
            return ResponseEntity.ok(pegawai);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Pegawai> createProduct(@RequestBody Pegawai pegawai) {
        Pegawai createdPegawai = pegawaiService.createPegawai(pegawai);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPegawai);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Pegawai> updatePegawai(@PathVariable Long id, @RequestBody Pegawai pegawai) {
        Pegawai updatedPegawai = pegawaiService.updatePegawai(id, pegawai);
        if (updatedPegawai != null) {
            return ResponseEntity.ok(updatedPegawai);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePegawai(@PathVariable Long id) {
        pegawaiService.deletePegawai(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
