package racing.service;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingService {
    public Cars createCarsByNames(String input) {
        return new Cars(
                Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList())
        );
    }

    public void turn(Cars cars) {
        for (Car car : cars) {
            car.tryMove();
        }
    }
}
