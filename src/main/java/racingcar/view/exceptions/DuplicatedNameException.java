package racingcar.view.exceptions;

public class DuplicatedNameException extends RuntimeException{
    public DuplicatedNameException(String message) {
        super(message);
    }
}