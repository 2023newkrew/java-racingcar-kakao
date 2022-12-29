package numberCalculator.exceptions;

public class NegativeArgumentException extends IllegalArgumentException {

    public NegativeArgumentException() {
        this("음수값은 사용할 수 없습니다.");
    }

    public NegativeArgumentException(String message) {
        super(message);
    }
}
