package racing_car.model;

import racing_car.util.Util;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;
    private int distance = 0;


    public Car(String name, int distance) {
        Util.validateName(name);
        this.name = name;
        this.distance = distance;
    }
    public Car(String name) {
        this(name, 0);
    }


    public int distance() {
        return this.distance;
    }
    public String name() {
        return this.name;
    }

    public void proceed(int threshold) {
        if (threshold > 4){
            this.distance += 1;
        }
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.distance, o.distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(name, car.name);
    }

}
