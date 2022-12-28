package racing_car.model;

import java.util.Random;

public class Game {

    private static final int START_THRESHOLD = 3;

    private static final int END_THRESHOLD = 10;

    private final Cars cars;

    public Game(Cars cars) {
        this.cars = cars;
    }

    public Cars getCars() {
        return cars;
    }

    private int generateRandomNumber() {
        return new Random().nextInt(END_THRESHOLD);
    }

    private void moveCar(int carIndex, int number) {
        if (number > START_THRESHOLD) {
            cars.moveCar(carIndex);
        }
    }

    public void moveCar(int carIndex) {
        int randomNumber = generateRandomNumber();
        moveCar(carIndex, randomNumber);
    }

    public void moveAllCars() {
        for (int i = 0; i < cars.length(); i++) {
            moveCar(i);
        }
    }

    public Cars getWinners() {
        return cars.getWinners();
    }
}
