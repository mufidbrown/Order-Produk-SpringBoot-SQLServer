package restorder.orderproduk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restorder.orderproduk.entity.Transaction;
import restorder.orderproduk.exception.ResourceNotFoundException;
import restorder.orderproduk.model.TransactionRequest;
import restorder.orderproduk.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

//    @GetMapping("/{id}")
//    public List<Transaction> getIdTransactions(@PathVariable Long id) {
//        Transaction transaction = transactionService.findById(id);
//        if (transaction == null) {
//            throw new ResourceNotFoundException("Example not found with ID: " + id);
//        }
//        return transactionService.getAllTransactions();
////        return ResponseEntity.ok(example);
////        return transaction.ok()findById(id).orElse(null);
//
//    }
        @GetMapping("/{id}")
        public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
            Transaction transaction = transactionService.findById(id);
            if (transaction == null) {
                throw new ResourceNotFoundException("Resource not found with id: " + id);
            }
            return ResponseEntity.ok(transaction);
        }


    @PostMapping
    public Transaction createTransaction(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.createTransaction(transactionRequest);
    }

}
