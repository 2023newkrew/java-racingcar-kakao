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

    public Cars getWinners(Cars cars) {
        Car maxPosCar = cars.getMaxPosCar();
        return cars.getSamePosCars(maxPosCar);
    }

    public String getWinnerNames(Cars cars) {
        Cars winnerCars = getWinners(cars);
        return winnerCars.toString();
    }

}
