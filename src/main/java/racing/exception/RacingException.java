package racing.exception;

public class RacingException extends RuntimeException {
    public RacingException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
