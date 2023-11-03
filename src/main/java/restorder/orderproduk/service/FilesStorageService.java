package restorder.orderproduk.service;

import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;


public interface FilesStorageService {

    public void init();

    public void save(MultipartFile file);

    public UrlResource load(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();

}
