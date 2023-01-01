package racing.domain;

import static racing.constant.MessageConstant.INVALID_BLANK_NAME_EXCEPTION;
import static racing.constant.MessageConstant.INVALID_NAME_LENGTH_EXCEPTION;

public class Name {

    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name == null || name.isBlank()) {
            throw new RuntimeException(INVALID_BLANK_NAME_EXCEPTION);
        }
        if (name.length() > MAX_LENGTH) {
            throw new RuntimeException(INVALID_NAME_LENGTH_EXCEPTION);
        }
    }

    public String getName() {
        return name;
    }
}
