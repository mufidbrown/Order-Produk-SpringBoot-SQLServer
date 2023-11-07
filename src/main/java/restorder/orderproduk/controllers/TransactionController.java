package restorder.orderproduk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.entity.Pegawai;
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
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

//    @GetMapping
//    public List<Transaction> getAllTransactions() {
//        return transactionService.getAllTransactions();
//    }

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
                throw new ResourceNotFoundException("Transaksi tidak ditemukan dengan id: " + id);
            }
            return ResponseEntity.ok(transaction);
        }


    @PostMapping
    public Transaction createTransaction(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.createTransaction(transactionRequest);
    }



    //-----------------------BaseResponse------------------------

    @GetMapping("/transaction/v1")
    public ResponseEntity<BaseResponse<List<Transaction>>> getAllTransactions2() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(BaseResponse.ok("Daftar Semua Transaksi", transactions));
    }



//    @GetMapping
//    public ResponseEntity<List<Pegawai>> getAllPegawais() {
//        List<Pegawai> pegawais = pegawaiService.getAllPegawais();
//        return new ResponseEntity<>(pegawais, HttpStatus.OK);
//    }
//
//    @GetMapping("/pegawai/v1")
//    public ResponseEntity<BaseResponse<List<Pegawai>>> getAllPegawais2() {
//        List<Pegawai> pegawais = pegawaiService.getAllPegawais();
//        return ResponseEntity.ok(BaseResponse.ok("Daftar Semua Pegawai", pegawais));
//
//    }

}
