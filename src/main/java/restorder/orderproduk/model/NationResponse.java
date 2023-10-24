package restorder.orderproduk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
