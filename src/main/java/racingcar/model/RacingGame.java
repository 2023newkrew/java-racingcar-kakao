package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int turn;
    private PowerGenerator powerGenerator;

    public RacingGame(List<String> carNames) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.turn = 0;
        this.powerGenerator = new PowerGenerator();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void proceedTurn() {
        for (Car car : cars) {
            car.accelerate(this.powerGenerator.getRandomPower());
        }
        this.turn += 1;
    }

    private int getMaxPosition() {
        int maxPosition = -1;
        for (Car car : this.cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private void collectFarthest(List<Car> farthestCars, Car racingCar, int maxPosition) {
        if (racingCar.getPosition() == maxPosition) {
            farthestCars.add(racingCar);
        }
    }

    public List<Car> getFarthestCars() {
        int maxPosition = this.getMaxPosition();
        List<Car> farthestCars = new ArrayList<>();
        for (Car car : this.cars) {
            this.collectFarthest(farthestCars, car, maxPosition);
        }
        return farthestCars;
    }
}
