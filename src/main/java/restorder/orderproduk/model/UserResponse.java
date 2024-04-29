package restorder.orderproduk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restorder.orderproduk.model.ConsumeRestApi.SupportResponse;
import restorder.orderproduk.model.ConsumeRestApi.DataResponse;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private DataResponse data;

    private SupportResponse support;


}
