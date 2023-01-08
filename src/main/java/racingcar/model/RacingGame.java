package racingcar.model;

import java.util.List;

public class RacingGame {
    private Cars cars;
    private PowerGenerator powerGenerator;

    public RacingGame(List<String> carNames) {
        this.cars = new Cars();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.powerGenerator = new RandomPowerGenerator();
        this.powerGenerator.setPowerGenerationStrategy(new RandomPowerGenerationStrategy());
    }

    public Cars getCars() {
        return this.cars;
    }

    public void proceedTurn() {
        for (Car car : cars.getCars()) {
            car.accelerate(this.powerGenerator.generatePower());
        }
    }

    private int getFarthestDistance() {
        int farthestDistance = -1;
        for (Car car : this.cars.getCars()) {
            farthestDistance = Math.max(farthestDistance, car.getDistance());
        }
        return farthestDistance;
    }

    private void collectFarthestCar(Cars farthestCars, Car racingCar, int farthestDistance) {
        if (racingCar.getDistance() == farthestDistance) {
            farthestCars.add(racingCar);
        }
    }

    public FarthestCars getFarthestCars() {
        int farthestDistance = this.getFarthestDistance();
        FarthestCars farthestCars = new FarthestCars(farthestDistance);
        for (Car car : this.cars.getCars()) {
            farthestCars.collectIfFarthest(car);
        }
        return farthestCars;
    }
}
