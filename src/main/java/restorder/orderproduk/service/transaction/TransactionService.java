package restorder.orderproduk.service.transaction;

import restorder.orderproduk.entity.Transaction;
import restorder.orderproduk.model.TransactionRequest;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransactions();
    Transaction findById(Long id);
    Transaction createTransaction(TransactionRequest transactionRequest);

}
