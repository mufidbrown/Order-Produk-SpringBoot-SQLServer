package restorder.orderproduk.service.user;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import restorder.orderproduk.entity.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class UserUploadService {

    public static boolean isValidExcelFile(MultipartFile file) {
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    public static List<User> getUsersDataFromExcel(InputStream inputStream) {
        List<User> users = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("users");

            int rowIndex =0;
            for (Row row : sheet){
                if (rowIndex ==0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                User user = new User();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
                        case 0 -> user.setId((long) cell.getNumericCellValue());
                        case 1 -> user.setUsername(cell.getStringCellValue());
                        case 2 -> user.setAlamat(cell.getStringCellValue());
                        case 3 -> user.setEmail(cell.getStringCellValue());
                        case 4 -> user.setTelepon(cell.getStringCellValue());
                        default -> {

                        }
                    }
                    cellIndex++;
                }
                users.add(user);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return users;
    }

}
