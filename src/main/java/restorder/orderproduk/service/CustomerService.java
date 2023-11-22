package restorder.orderproduk.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import restorder.orderproduk.entity.Customer;
import restorder.orderproduk.repositories.CustomerRepository;
import restorder.orderproduk.service.user.ExcelUploadService;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public void saveCustomersToDatabase(MultipartFile file){
        if (ExcelUploadService.isValidExcelFile(file)){
            try {
                List<Customer> customers = ExcelUploadService.getCustomersDataFromExcel(file.getInputStream());
                this.customerRepository.saveAll(customers);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
}
