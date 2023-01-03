package calculator;

public class NegativeValueException extends RuntimeException {
    private static final String MSG = "음수는 계산할 수 없습니다.";

    public NegativeValueException() {
        super(MSG);
    }
}
