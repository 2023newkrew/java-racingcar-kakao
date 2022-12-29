package racing_car.model;

import racing_car.strategy.MoveCarStrategy;

import java.util.Collections;
import java.util.stream.Collectors;

public class Game {

    private final Cars cars;

    private final MoveCarStrategy moveCarStrategy;

    public Game(Cars cars, MoveCarStrategy moveCarStrategy) {
        this.cars = cars;
        this.moveCarStrategy = moveCarStrategy;
    }

    public Cars getCars() {
        return cars;
    }

    private void moveCar(int carIndex) {
        if (!moveCarStrategy.isMovable()) {
            return;
        }

        cars.moveCar(carIndex);
    }

    public void moveAllCars() {
        for (int i = 0; i < cars.length(); i++) {
            moveCar(i);
        }
    }

    public Cars getWinners() {
        Car farthestCar = findFarthestCar();
        return Cars.of(cars.getCars().stream()
                .filter(car -> car.compareTo(farthestCar) == 0)
                .collect(Collectors.toList()));
    }

    private Car findFarthestCar() {
        return Collections.max(cars.getCars());
    }
}
