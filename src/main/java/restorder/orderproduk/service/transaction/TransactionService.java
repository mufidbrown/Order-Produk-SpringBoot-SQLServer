package restorder.orderproduk.service.transaction;

import restorder.orderproduk.api.BaseResponse;
import restorder.orderproduk.entity.Transaction;
import restorder.orderproduk.model.request.TransactionRequest;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransactions();
    Transaction findById(Long id);
    Transaction createTransaction(TransactionRequest transactionRequest);

    BaseResponse<?> test();

    BaseResponse<?> testParameter(Integer idPegawai);
}
