package racingcar;

import java.util.List;

public class RacingSimulator {

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;
    private final int maxTryCount;
    private int tryCount;

    public RacingSimulator(int maxTryCount, NumberGenerator numberGenerator, List<Car> cars) {
        this.maxTryCount = maxTryCount;
        this.tryCount = 0;
        this.numberGenerator = numberGenerator;
        this.cars = cars;
    }

    public void move() {
        if(isNotTryable()){
            throw new IllegalStateException();
        }

        moveCars();
    }

    private boolean isNotTryable() {
        return tryCount >= maxTryCount;
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
        tryCount++;
    }

    public Result getResult() {
        return new Result(cars);
    }

    public Car getWinner() {
        int winnerPosition = winnerPosition();

        return cars.stream()
                .filter(car -> isWinner(winnerPosition, car))
                .findFirst()
                .orElseThrow();
    }

    private static boolean isWinner(int winnerPosition, Car car) {
        return car.getPosition() == winnerPosition;
    }

    private int winnerPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }
}
