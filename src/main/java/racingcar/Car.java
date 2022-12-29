package racingcar;

import java.util.Random;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void forward() {
        forward(new Random().nextInt(10));
    }

    public void forward(int power) {
        if(power >= 4)
            distance++;
    }

    public int getDistance(){
        return this.distance;
    }


    public String getName() {
        return name;
    }
}
