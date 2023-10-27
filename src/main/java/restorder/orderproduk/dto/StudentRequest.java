package restorder.orderproduk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(staticName = "build")
public class StudentRequest {

    private String name;
    private int age;
    private String address;
    private String email;

}
