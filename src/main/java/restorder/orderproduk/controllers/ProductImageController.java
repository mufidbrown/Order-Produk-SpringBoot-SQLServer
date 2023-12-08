package restorder.orderproduk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import restorder.orderproduk.service.ProductImageService;

import java.io.IOException;

@RestController
public class ProductImageController {

    @Autowired
    private ProductImageService productImageService;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/upload")
    public void uploadImage(@RequestParam("productImage") MultipartFile file) throws IOException {
        productImageService.uploadImage(file);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) throws IOException {
        byte[] image = productImageService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }
}
