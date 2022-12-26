package racing.exception;

public class CarNameInvalidException extends RuntimeException {
    private ErrorCode errorCode;

    public CarNameInvalidException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
