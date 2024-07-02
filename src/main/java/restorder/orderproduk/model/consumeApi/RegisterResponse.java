package restorder.orderproduk.model.consumeApi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {

    private Integer id;

    private String token;

    //consume Api post nampilin response, class ini terkait dengan RegisterRequest
    // consume Api Query Body /@RequestBody

}
