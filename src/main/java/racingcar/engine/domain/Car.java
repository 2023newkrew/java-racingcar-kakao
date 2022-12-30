package racingcar.engine.domain;

import java.util.List;
import java.util.Objects;

public class Car {
    private String name;
    private int position = 1;

    private final static int MAX_NAME_LENGTH = 5;

    public Car(String name, int position) {
        setName(name);
        setPosition(position);
    }

    public Car(String name) {
        this(name, 1);
    }

    public int getPosition() {
        return position;
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException("잘못된 자동차 이름입니다.");
        }
        this.name = name;
    }

    private void setPosition(int position) {
        if (position < 1) {
            throw new RuntimeException("잘못된 위치입니다.");
        }
        this.position = position;
    }

    public void moveWithPower(int power) {
        if (power > 3) {
            this.position++;
        }
    }

    public int renewWinners(int max, List<String> result) {
        if (position < max) {
            return max;
        }
        if (position > max) {
            result.clear();
        }
        result.add(name);
        return position;
    }

    public String getCurrentPosition() {
        return this.name + " : "
                + "-".repeat(Math.max(0, this.position));
    }
}
