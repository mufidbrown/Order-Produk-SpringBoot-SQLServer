package restorder.orderproduk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import restorder.orderproduk.entity.Excel;
import restorder.orderproduk.exception.ExcelHelper;
import restorder.orderproduk.repositories.ExcelRepository;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    ExcelRepository excelRepository;

    public void save(MultipartFile file) {
        try {
            List<Excel> excels = ExcelHelper.excelToExcels(file.getInputStream());
            excelRepository.saveAll(excels);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<Excel> excels = excelRepository.findAll();

        ByteArrayInputStream in = ExcelHelper.excelsToExcel(excels);
        return in;
    }

    public List<Excel> getAllExcels() {
        return excelRepository.findAll();
    }

}
