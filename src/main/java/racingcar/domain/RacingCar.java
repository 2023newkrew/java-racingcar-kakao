package racingcar.domain;

import org.apache.commons.lang3.StringUtils;

public class RacingCar implements Car {
    private static final int BOUND = 3;
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int distance;

    public RacingCar(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(name) || StringUtils.isBlank(name)) {
            throw new NullPointerException();
        }
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    public void move(int seed) {
        if (seed > BOUND) {
            distance++;
        }
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, "-".repeat(distance));
    }
}
