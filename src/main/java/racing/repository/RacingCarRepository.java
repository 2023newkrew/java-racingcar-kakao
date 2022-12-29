package racing.repository;

import racing.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCarRepository {
    private static List<Car> cars = new ArrayList<>();

    public static void init(List<Car> newCars){
        cars = newCars;
    }

    public static List<Car> getCars(){
        return cars;
    }

    public static List<String> getWinners() {
        Integer max = Collections.max(cars).getPosition();
        return cars.stream()
                .filter(car -> Objects.equals(car.getPosition(), max))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
