package racingcar.model;

import racingcar.util.Movable;

public abstract class Car {
    protected final String name;
    protected int position;

    public Car(String name, int defaultPosition) {
        this.name = name;
        this.position = defaultPosition;
    }

    public abstract void move(Movable movable);

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
