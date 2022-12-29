package racingcar.domain;

import java.util.Random;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (pickRandomNumber() >= 4) {
            position++;
        }
    }

    public int pickRandomNumber() {
        return new Random().nextInt(10);
    }

    @Override
    public String toString() {
        return String.format("차 이름: %s, 거리: %d", name, position);
    }
}