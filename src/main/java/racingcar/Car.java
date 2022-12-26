package racingcar;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(int seed){
        if(seed>3){
            distance++;
        }
    }
}
