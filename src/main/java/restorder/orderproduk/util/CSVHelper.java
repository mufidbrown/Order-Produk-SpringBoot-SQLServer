package restorder.orderproduk.util;

import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;
import restorder.orderproduk.entity.User;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CSVHelper {

    public static String TYPE = "text/csv";
    static String[] HEADERs = { "nim", "nama", "email" };

    public static boolean hasCSVFormat(MultipartFile file) {
        final String contentType = file.getContentType();
        if(TYPE.equals(contentType) || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }
        return false;
    }

    public static List<User> transformCSVToList(InputStream inputStream) {
        try(BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<User> userList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for(CSVRecord csvRecord: csvRecords) {
                User user = User.builder()
                        .username(csvRecord.get("username"))
                        .alamat(csvRecord.get("alamat"))
                        .email(csvRecord.get("email"))
                        .telepon(csvRecord.get("telepon"))
                        .build();

                userList.add(user);
            }

            return userList;
        }catch (IOException e) {
            throw new RuntimeException("Failed to parse CSV file "+ e.getMessage());
        }
    }

    public static ByteArrayInputStream userToCSV(List<User> userList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try(ByteArrayOutputStream out = new ByteArrayOutputStream();
            CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);)  {

            for(User user: userList) {
                List<String> data = Arrays.asList(
                        user.getUsername(),
                        user.getAlamat(),
                        user.getEmail(),
                        user.getTelepon()
                );
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        }catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }

}
