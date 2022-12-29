package racing_car.model;

import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {

    private final Cars cars;

    private static final int MIN_RANGE_FOR_MOVE = 4;

    private static final int MAX_RANGE_FOR_MOVE = 9;

    private final Random random = new Random();

    public Game(Cars cars) {
        this.cars = cars;
    }

    public Cars getCars() {
        return cars;
    }

    private int generateRandomNumber() {
        return random.nextInt(MAX_RANGE_FOR_MOVE + 1);
    }

    private void moveCar(int carIndex, int number) {
        if (number >= MIN_RANGE_FOR_MOVE) {
            cars.moveCar(carIndex);
        }
    }

    private void moveCar(int carIndex) {
        int randomNumber = generateRandomNumber();
        moveCar(carIndex, randomNumber);
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
