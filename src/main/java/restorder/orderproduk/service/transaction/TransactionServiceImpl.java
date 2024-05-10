package restorder.orderproduk.service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.entity.Transaction;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.model.TransactionRequest;
import restorder.orderproduk.repositories.ProductRepository;
import restorder.orderproduk.repositories.TransactionRepository;
import restorder.orderproduk.repositories.UserRepository;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }


    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }





    public Transaction createTransaction(TransactionRequest transactionRequest) {
        Transaction transaction = new Transaction();
        User user = userRepository.findById(transactionRequest.getUserId()).
                orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(transactionRequest.getProductId()).
                orElseThrow(() -> new RuntimeException("Product not found"));
        transaction.setUser(user);
        transaction.setProduct(product);
        return transactionRepository.save(transaction);
    }



//        public List<Transaction> getTransactionsById() {
//        return transactionRepository.gById(id);
//    }

//        public Transaction findById(Long id) {
//
//    }

}
