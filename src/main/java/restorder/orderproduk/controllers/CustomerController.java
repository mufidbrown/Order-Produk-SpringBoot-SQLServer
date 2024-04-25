package restorder.orderproduk.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import restorder.orderproduk.entity.Customer;
import restorder.orderproduk.service.ImportExport.CustomerService;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("customers")
public class CustomerController {

    private CustomerService customerService;
    @PostMapping("/upload-customers-data")
    public ResponseEntity<?> uploadCustomersData(@RequestParam("file") MultipartFile file){
        this.customerService.saveCustomersToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message", "Customers data uploaded and save to database successfully"));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.FOUND);
    }
}
