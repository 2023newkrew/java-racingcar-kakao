package racing_car.model;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars == null ? new ArrayList<>() : new ArrayList<>(cars);
    }

    private Cars(Car[] cars) {
        this(List.of(cars));
    }

    private Cars(String[] names) {
        this(Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars of(Car[] cars) {
        return new Cars(cars);
    }

    public static Cars of(String[] names) {
        return new Cars(names);
    }

    private Car get(int index) {
        if (index >= cars.size()) {
            throw new IndexOutOfBoundsException("해당 자동차가 존재하지 않습니다.");
        }

        return cars.get(index);
    }

    public int length() {
        return this.cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private void moveCar(int index, int step) {
        get(index).move(step);
    }

    public void moveCar(int index) {
        moveCar(index, 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }
}
