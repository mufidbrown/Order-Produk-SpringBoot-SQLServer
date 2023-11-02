package restorder.orderproduk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restorder.orderproduk.entity.Transaction;
import restorder.orderproduk.repositories.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction createTransaction(Long userId, Long productId) {
        Transaction transaction = new Transaction();
        transaction.setUserId(userId);
        transaction.setProductId(productId);
        return transactionRepository.save(transaction);
    }


}
