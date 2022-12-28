package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int turn;

    public RacingGame(List<String> carNames) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.turn = 0;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int generateRandomNumber() {
        return (int)(Math.random()*10) %10;
    }

    public void proceedTurn() {
        for(Car car : cars) {
            car.accelerate(this.generateRandomNumber());
        }
        this.turn += 1;
    }

    public List<Car> getFarthestCars() {
        int maxPosition = -1;
        for(Car car : this.cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        List<Car> farthestCars = new ArrayList<>();
        for(Car car : this.cars) {
            this.collectFarthest(farthestCars, car, maxPosition);
        }
        return farthestCars;
    }

    public void collectFarthest(List<Car> farthestCars, Car racingCar, int maxPosition) {
        if(racingCar.getPosition() == maxPosition) {
            farthestCars.add(racingCar);
        }
    }
}
