package racingcar.domain;

import racingcar.domain.stratedy.MovableStrategy;
import racingcar.domain.stratedy.RandomStratedy;

public class Car implements Comparable<Car> {
    private final String name;
    private int distance;
    private MovableStrategy movableStrategy = new RandomStratedy();

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.distance = 0;
    }

    public Car(String name, MovableStrategy movableStrategy) {
        this(name);
        this.movableStrategy = movableStrategy;
    }

    private void validateName(String name) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException();
        if (name.length() > 5)
            throw new IllegalArgumentException();
    }

    public void forward() {
        if (movableStrategy.isMove())
            distance++;
    }

    public int getDistance() {
        return this.distance;
    }


    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(car.distance, distance);
    }
}
