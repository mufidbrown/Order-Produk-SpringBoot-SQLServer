package restorder.orderproduk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PegawaiExceptionHandler {


//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
//        ErrorResponse errorResponse = new ErrorResponse("Internal Server Error", 500, ex.getMessage());
//        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(Exception.class)
    public  ResponseEntity<PegawaiErrorResponse> handleException(Exception ex) {
        PegawaiErrorResponse PegawaiErrorResponse  = new PegawaiErrorResponse("Internal Server Error", 500, ex.getMessage());
        return new ResponseEntity<>(PegawaiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
