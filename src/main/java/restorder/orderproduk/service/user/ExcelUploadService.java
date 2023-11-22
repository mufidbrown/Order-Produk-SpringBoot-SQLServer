package restorder.orderproduk.service.user;

import org.springframework.web.multipart.MultipartFile;
import restorder.orderproduk.entity.Customer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExcelUploadService {
    public static boolean isValidExcelFile(MultipartFile file) {
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    public static List<Customer> getCustomersDataFromExcel(InputStream inputStream) {
        List<Customer> customers = new ArrayList<>();
    }
}
