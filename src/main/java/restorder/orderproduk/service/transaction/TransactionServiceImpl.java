package restorder.orderproduk.service.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.entity.Product;
import restorder.orderproduk.entity.Transaction;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.model.request.TransactionRequest;
import restorder.orderproduk.model.response.TransactionResponse;
import restorder.orderproduk.repositories.ProductRepository;
import restorder.orderproduk.repositories.TransactionRepository;
import restorder.orderproduk.repositories.UserRepository;

import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;



@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final EntityManager entityManager;

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

      /*
    Dibawah ini untuk QueryNative PL/SQL!
*/


    @Override
    public BaseResponse<?> test() {
        Query query = entityManager.createNativeQuery("SELECT nik, nama, alamat, email, jabatan, telepon  from pegawais p WHERE id_pegawai = 11");
        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
        TransactionResponse transactionResponse = TransactionResponse.builder()
                .nik(list.get(0).toString())
                .nama(list.get(1).toString())
                .jabatan(list.get(2).toString())
                .alamat(list.get(3).toString())
                .email(list.get(4).toString())
                .telepon(list.get(5).toString())
                .build();
        return BaseResponse.ok(transactionResponse);
        // PegawaiServiceImpl di panggil/test tahap akhir di TestPegawaiController
    }

    @Override
    public BaseResponse<?> testParameter(Integer idPegawai) {
        Query query = entityManager.createNativeQuery("SELECT nik,  nama,  alamat, email, jabatan, telepon  from pegawais p WHERE id_pegawai = ?1");
        query.setParameter(1, idPegawai);
        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
        TransactionResponse transactionResponse = TransactionResponse.builder()
                .nik(list.get(0).toString())
                .nama(list.get(1).toString())
                .jabatan(list.get(2).toString())
                .alamat(list.get(3).toString())
                .email(list.get(4).toString())
                .telepon(list.get(5).toString())
                .build();
        return BaseResponse.ok(transactionResponse);

    }




//        public List<Transaction> getTransactionsById() {
//        return transactionRepository.gById(id);
//    }

//        public Transaction findById(Long id) {
//
//    }

}
