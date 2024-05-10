package restorder.orderproduk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restorder.orderproduk.entity.Transaction;
import restorder.orderproduk.exception.ResourceNotFoundException;
import restorder.orderproduk.model.request.TransactionRequest;
import restorder.orderproduk.service.transaction.TransactionServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;

    @PostMapping
    public Transaction createTransaction(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.createTransaction(transactionRequest);
    }


    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transaction = transactionService.findById(id);
        if (transaction == null) {
            throw new ResourceNotFoundException("Transaksi tidak ditemukan dengan id: " + id);
        }
        return ResponseEntity.ok(transaction);
    }




    //-----------------------BaseResponse------------------------

    //ini yang dipakai
//    @GetMapping("/transaction/v1")
//    public ResponseEntity<BaseResponse<List<Transaction>>> getAllTransactions2() {
//        List<Transaction> transactions = transactionService.getAllTransactions();
//        return ResponseEntity.ok(BaseResponse.ok("Daftar Semua Transaksi", transactions));
//    }

//    @GetMapping("/pegawai/v1/{id}")
//    public ResponseEntity<BaseResponse<Pegawai>> getPegawaiById2(@PathVariable("id") Long id) {
//        Pegawai pegawai = pegawaiService.getPegawaiById(id);
//        if (pegawai != null) {
//            return ResponseEntity.ok(BaseResponse.ok("Pegawai Ditemukan", pegawai));
//        } else {
//            return ResponseEntity.ok(BaseResponse.error("Pegawai Tidak Ditemukan"));
//        }
//    }

    //ini yang dipakai
//    @GetMapping("/transaction/v1/{id}")
//    public ResponseEntity<BaseResponse<Transaction>> getTransactionById2(@PathVariable("id") Long id) {
//        Transaction transaction = transactionService.findById(id);
//        if (transaction != null) {
//            return ResponseEntity.ok(BaseResponse.ok("Transaksi Ditemukan", transaction));
//        } else {
//            return ResponseEntity.ok(BaseResponse.error("Transaksi Tidak Ditemukan dengan id: " + id));
//        }
//    }







}
