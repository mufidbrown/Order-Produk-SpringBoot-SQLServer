package restorder.orderproduk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{id}")
    public List<Transaction> getAllTransactions(@PathVariable Long id) {
        Transaction transaction = transactionService.getTransactionById(id);
        if (transaction == null) {
            throw new ResourceNotFoundException("Example not found with ID: " + id);
        }
        return transactionService.getAllTransactions();
//        return ResponseEntity.ok(example);

    }

    @PostMapping
    public Transaction createTransaction(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.createTransaction(transactionRequest);
    }

}
