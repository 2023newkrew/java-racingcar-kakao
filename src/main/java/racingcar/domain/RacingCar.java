package racingcar.domain;

import org.apache.commons.lang3.StringUtils;

public class RacingCar implements Car {
    private static final int BOUND = 3;
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public RacingCar(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(name) || StringUtils.isBlank(name)) {
            throw new NullPointerException();
        }
        this.name = name;
        this.position = 0;
    }

    public RacingCar(String name, int position) {
        this(name);
        this.position = position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getPosition() {
        return this.position;
    }

    public void move(int seed) {
        if (seed > BOUND) {
            position++;
        }
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, "-".repeat(position));
    }
}
