package racing_car.model;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;
    private int distance = 0;


    public Car(String name, int distance) {
        validateName(name);
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


    private void validateName(String input) {
        if (input.length() < 1){
            throw new RuntimeException("이름은 한글자 이상이어야 합니다.");
        }
        if (input.length() > 5){
            throw new RuntimeException("이름은 다섯글자 이하여야 합니다.");
        }
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
