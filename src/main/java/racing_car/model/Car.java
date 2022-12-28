package racing_car.model;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final Racer racer;

    private int distance = 0;

    public Car(String racerName) {
        this.racer = new Racer(racerName);
    }

    public Racer getRacer() {
        return racer;
    }

    public String displayDistance() {
        return "-".repeat(this.distance);
    }

    public void move(int step) {
        this.distance += step;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.distance, o.distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;
        return distance == car.distance && Objects.equals(racer, car.racer);
    }
}
