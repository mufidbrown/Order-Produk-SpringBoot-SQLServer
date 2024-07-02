package restorder.orderproduk.controllers.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import restorder.orderproduk.config.BaseResponse;
import restorder.orderproduk.service.transaction.TransactionService;

@RestController
public class TestTransaction {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/test")
    public BaseResponse<?> test() {
        return transactionService.test();
    }

    @GetMapping("/test/v1/{id_transaction}")
    public BaseResponse<?> testParameter(@PathVariable Integer id_transaction){
        return transactionService.testParameter(id_transaction);
    }

}
