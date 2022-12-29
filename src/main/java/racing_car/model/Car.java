package racing_car.model;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;

    private int distance = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String input) {
        if (input.length() < 1){
            throw new RuntimeException("이름은 한글자 이상이어야 합니다.");
        }
    }

    public String name() {
        return name;
    }

    public static Car[] from(String names){
        String[] separatedNames = names.split(",");
        Car[] cars = new Car[separatedNames.length];
        for (int i = 0; i < separatedNames.length; i++) {
            cars[i] = new Car(separatedNames[i]);
        }
        return cars;
    }

    public String showDistance() {
        return "-".repeat(this.distance);
    }

    public void move(int i) {
        this.distance += i;
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

    public int distance() {
        return this.distance;
    }

    public void proceed(int threshold) {
        if (threshold > 4){
            this.distance += 1;
        }
    }
}
