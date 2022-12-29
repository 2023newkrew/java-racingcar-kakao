package racing.domain;

import java.util.Objects;

public class CarName {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String TOO_SHORT_NAME_EXCEPTION_MESSAGE = "[ERROR] 이름의 길이는 최소 1글자여야 합니다.";
    private static final String TOO_LONG_NAME_EXCEPTION_MESSAGE = "[ERROR] 이름의 길이는 최대 5글자까지만 가능합니다.";

    private final String name;

    public CarName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 이름은 공백으로만 이루어질 수 없습니다.");
        }
        validate(name);
        this.name = name;
    }

    public void validate(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(TOO_SHORT_NAME_EXCEPTION_MESSAGE);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(TOO_LONG_NAME_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarName)) {
            return false;
        }
        return ((CarName) o).name.
                equals(this.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
