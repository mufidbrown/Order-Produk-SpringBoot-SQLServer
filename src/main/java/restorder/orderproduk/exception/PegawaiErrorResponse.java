package restorder.orderproduk.exception;

public class PegawaiErrorResponse {

    private String error;
    private int status;
    private String message;

    public PegawaiErrorResponse(String error, int status, String message) {
        this.error = error;
        this.status = status;
        this.message = message;
    }
}
