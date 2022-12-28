package racingcar.service;

import racingcar.service.stratedy.MovableStrategy;
import racingcar.service.stratedy.RandomStratedy;

public class Car implements Comparable<Car> {
    private final String name;
    private int distance = 0;
    private MovableStrategy movableStrategy = new RandomStratedy();

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void setMovableStrategy(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
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
        return Integer.compare(((Car)car).distance, distance);
    }
}
