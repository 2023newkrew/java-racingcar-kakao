package car_racing.common.exception;

public class InvalidInputFormatException extends RuntimeException {

    InvalidInputFormatException() {

    }

    InvalidInputFormatException(String message) {
        super(message);
    }
}
