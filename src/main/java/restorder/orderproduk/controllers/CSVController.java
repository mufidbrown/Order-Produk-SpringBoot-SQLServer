package restorder.orderproduk.controllers;

import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import restorder.orderproduk.service.user.CSVService;


@RestController
@RequestMapping("/api/v1/csv")
@AllArgsConstructor
public class CSVController {

    private CSVService csvService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCSV(@RequestParam("file") MultipartFile file) {
        try {
            csvService.save(file);
            return ResponseEntity.status(HttpStatus.OK).body("Upload CSV Sukses");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Terjadi kesalahan pada saat upload");
        }
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile() {
        String filename = "mahasiswa-data.csv";

        InputStreamResource file  = new InputStreamResource(csvService.load());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }
}