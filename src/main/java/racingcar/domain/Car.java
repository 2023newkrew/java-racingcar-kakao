package racingcar.domain;

import java.util.Random;

public class Car {
    public static final int MAXIMUM_POWER = 10;
    public static final int FORWARD_THRESHOLD = 4;

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void forward() {
        forward(new Random().nextInt(MAXIMUM_POWER));
    }

    public void forward(int power) {
        if(power >= FORWARD_THRESHOLD)
            distance++;
    }

    public int getDistance(){
        return this.distance;
    }


    public String getName() {
        return name;
    }
}
