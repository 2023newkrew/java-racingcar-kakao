package numberCalculator.exceptions;

public class InvalidFormatException extends RuntimeException{
    public InvalidFormatException() {
        super("숫자/구분자가 잘못 작성되었습니다.");
    }

    public InvalidFormatException(String message) {
        super(message);
    }
}
