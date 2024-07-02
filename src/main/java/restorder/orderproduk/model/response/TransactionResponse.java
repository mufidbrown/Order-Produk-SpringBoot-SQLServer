package restorder.orderproduk.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TransactionResponse {
    private String nik;

    private String nama;

    private String jabatan;

    private String alamat;

    private String email;

    private String telepon;

}
