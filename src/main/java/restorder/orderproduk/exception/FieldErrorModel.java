package restorder.orderproduk.exception;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FieldErrorModel implements Serializable {
    private static final long serialVersionUID = 6525228192960931469L;
    private String field;
    private String message;
}


