package racingcar.domain;

import racingcar.util.RandomGeneratorImpl;

import java.util.Arrays;


public class Racing {
    private Car[] cars;

    public void generateCars(String[] carNames) {
        cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    public Car[] cars() {
        return cars;
    }

    public void proceedRound() {
        for (Car car : cars) {
            car.move(new RandomGeneratorImpl());
        }
    }

    public Car getOneWinner() {
        Car candidate = cars[0];
        for (Car car : cars) {
            candidate = candidate.determineWinner(car);
        }
        return candidate;
    }

    public Car[] getTotalWinners() {
        Car winner = getOneWinner();
        return Arrays.stream(cars)
                .filter(car -> car.equalsPositionToOtherCar(winner))
                .toArray(Car[]::new);
    }
}