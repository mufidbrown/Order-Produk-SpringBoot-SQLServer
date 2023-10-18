package restorder.orderproduk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
}

