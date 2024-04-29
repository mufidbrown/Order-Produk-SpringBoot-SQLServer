package restorder.orderproduk.model.ConsumeRestApi;

import lombok.*;

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
