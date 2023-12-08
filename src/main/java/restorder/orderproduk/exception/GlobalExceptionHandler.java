package restorder.orderproduk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import restorder.orderproduk.api.BaseResponse;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseStatusException handleResourceNotFoundException(ResourceNotFoundException ex) {
//        return new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
//    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        List<FieldErrorModel> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(x -> new FieldErrorModel(x.getField(), x.getDefaultMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(BaseResponse.error("Validation Error"));
    }
}
