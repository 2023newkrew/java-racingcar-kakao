package racingcar;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void forward() {
        distance += (int)(Math.random() * 10) >= 4 ? 1 : 0;
    }

    public int getDistance(){
        return this.distance;
    }


    public String getName() {
        return name;
    }
}
