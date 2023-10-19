package restorder.orderproduk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

// model PegawaiResponse dipaggil ke PegawaiServiceImpl
public class PegawaiResponse {

    private String nik;

    private String nama;

    private String jabatan;

    private String alamat;

    private String email;

    private String telepon;

}
