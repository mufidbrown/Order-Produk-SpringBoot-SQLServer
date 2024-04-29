package restorder.orderproduk.model.ConsumeRestApi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse {
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;


}
