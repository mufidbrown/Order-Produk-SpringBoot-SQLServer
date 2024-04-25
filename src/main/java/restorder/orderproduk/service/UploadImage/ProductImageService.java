package restorder.orderproduk.service.UploadImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import restorder.orderproduk.entity.ProductImage;
import restorder.orderproduk.repositories.ProductImageRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class ProductImageService {

    @Autowired
    private ProductImageRepository imageRepo;

    private final String PATH = "C:\\UploadJPG\\";

    public ProductImage uploadImage(MultipartFile file) throws IOException {
        String fullPath = PATH+file.getOriginalFilename();
        ProductImage pImage = new ProductImage();
        pImage.setName(file.getOriginalFilename());
        pImage.setType(file.getContentType());
        pImage.setImagePath(fullPath);

        file.transferTo(new File(fullPath));
        return imageRepo.save(pImage);
    }

    public byte[] downloadImage(String fileName) throws IOException{
        Optional<ProductImage> imageObject = imageRepo.findByName(fileName);
        String fullPath = imageObject.get().getImagePath();
        return Files.readAllBytes(new File(fullPath).toPath());
    }
}
