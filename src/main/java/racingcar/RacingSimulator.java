package racingcar;

import java.util.List;

public class RacingSimulator {

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public RacingSimulator(NumberGenerator numberGenerator, List<Car> cars) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public Result getResult() {
        return new Result(cars);
    }
}
