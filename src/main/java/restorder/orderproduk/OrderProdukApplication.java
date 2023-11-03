package restorder.orderproduk;

import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import restorder.orderproduk.service.FilesStorageService;

@SpringBootApplication
public class OrderProdukApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrderProdukApplication.class, args);
	}

	@Resource
	FilesStorageService storageService;



	@Override
	public void run(String... arg) throws Exception {
//    storageService.deleteAll();
		storageService.init();
	}
}
