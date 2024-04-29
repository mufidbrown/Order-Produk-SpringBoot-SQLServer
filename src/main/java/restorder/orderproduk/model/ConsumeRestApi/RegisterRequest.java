package restorder.orderproduk.model.ConsumeRestApi;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.intellij.lang.annotations.RegExp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {


    private String email;
    @Size(min = 8, max = 10)
    private String password;


}
