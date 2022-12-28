package racing_car.model;

import java.util.Objects;

public class Racer {

    private final String name;

    private static final int MAX_LENGTH = 5;

    public Racer(String name) throws IllegalArgumentException {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 1자 이상이여야 합니다.");
        }

        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Racer racer = (Racer) o;
        return Objects.equals(name, racer.name);
    }
}
