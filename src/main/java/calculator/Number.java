package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number {
    private final int value;

    public Number(String value) {
        Matcher m = Pattern.compile("(\\d*)").matcher(value);
        if (!m.matches()) {
            throw new IllegalArgumentException("0부터 9 사이의 수만 입력할 수 있습니다.");
        }
        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
