package racingcar.domain;

import java.util.Random;

public class Car {
    public static final int MAXIMUM_POWER = 10;
    public static final int FORWARD_THRESHOLD = 4;

    private final String name;
    private int distance;

    public Car(String name) throws RuntimeException {
        if(name == null || name.isEmpty())
            throw new RuntimeException("자동차의 이름이 없습니다.");
        if(name.length() > 5)
            throw new RuntimeException("자동차의 이름은 5자 이하로 적어야 합니다.");

        this.name = name;
        this.distance = 0;
    }

    public void forward() {
        forward(getRandomNumber());
    }

    public void forward(int power) {
        if(power >= FORWARD_THRESHOLD)
            distance++;
    }

    protected int getRandomNumber(){
        return new Random().nextInt(MAXIMUM_POWER);
    }

    public int getDistance(){
        return this.distance;
    }


    public String getName() {
        return name;
    }
}
