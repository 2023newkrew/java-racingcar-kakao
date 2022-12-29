package racingcar.view.exceptions;

public class InvalidFormatException extends RuntimeException{

    public InvalidFormatException() {
    }

    public InvalidFormatException(String message) {
        super(message);
    }
}
