package racingcar.domain;

import racingcar.dto.CarDto;
import racingcar.utils.RandomNumberGenerator;

public class Car implements MovableStrategy{
    private final String name;
    private int position = 1;

    public Car(final String name) {
        this.name = name;
    }

    public void move() {
        if (isMovable()) {
            position += 1;
        }
    }

    @Override
    public boolean isMovable() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        return randomNumberGenerator.generateBetweenZeroAndNine() >= Threshold.NORMAL_THRESHOLD.getNumber();
    }

    public boolean isSamePosition(Car other) {
        return position == other.position;
    }

    public int comparePosition(Car other) {
        return position - other.position;
    }

    public CarDto toDto() {
        return new CarDto(name, position);
    }

}
