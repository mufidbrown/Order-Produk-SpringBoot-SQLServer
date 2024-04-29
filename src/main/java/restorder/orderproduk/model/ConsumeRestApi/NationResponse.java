package restorder.orderproduk.model.ConsumeRestApi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restorder.orderproduk.model.ConsumeRestApi.CountryResponse;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NationResponse {

    private Integer count;

    private String name;

//    private Object country;

    private ArrayList<CountryResponse> country;

 // consume Api Query Params /@RequestParams
}
