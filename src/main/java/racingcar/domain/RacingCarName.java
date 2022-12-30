package racingcar.domain;

import java.util.Objects;

public class RacingCarName {
    private final String name;

    public RacingCarName(String name) {
        if (isInvalid(name)) {
            throw new IllegalArgumentException("잘못된 이름입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static boolean isInvalid(String name) {
        return name == null || name.isBlank() || name.length() > 5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCarName that = (RacingCarName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
