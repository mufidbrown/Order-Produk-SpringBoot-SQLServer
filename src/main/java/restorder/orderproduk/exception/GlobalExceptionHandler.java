package restorder.orderproduk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseStatusException handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
