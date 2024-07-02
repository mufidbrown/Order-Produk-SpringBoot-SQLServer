package restorder.orderproduk.model.consumeApi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {

    private String name;

    private String job;

    private String id;

    private String createdAt;

}
