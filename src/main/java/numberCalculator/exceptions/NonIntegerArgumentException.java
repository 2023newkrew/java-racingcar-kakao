package numberCalculator.exceptions;

public class NonIntegerArgumentException extends IllegalArgumentException {

    public NonIntegerArgumentException() {
        this("숫자 이외의 값은 사용할 수 없습니다.");
    }

    public NonIntegerArgumentException(String message) {
        super(message);
    }
}
