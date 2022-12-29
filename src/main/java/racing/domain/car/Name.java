package racing.domain.car;

import calculator.constant.MessageConstant;

import static calculator.constant.MessageConstant.INVALID_INPUT_EXCEPTION;

public class Name {
    private final String name;

    private static final int MAX_LENGTH = 5;
    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new RuntimeException(INVALID_INPUT_EXCEPTION);
        }
    }

    public String getName() {
        return name;
    }
}
