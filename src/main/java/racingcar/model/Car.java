package racingcar.model;

import racingcar.model.stratedy.MovableStrategy;
import racingcar.model.stratedy.RandomStratedy;

public class Car {
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
}
