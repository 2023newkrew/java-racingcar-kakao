package racingcar.exception;

public class RacingException extends RuntimeException {

    public RacingException(RacingExceptionCode racingExceptionCode) {
        super(racingExceptionCode.getErrorMessage());
    }
}
