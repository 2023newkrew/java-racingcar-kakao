package racingcar.model;

import java.util.List;

public class Cars {

    private final NumberGenerator numberGenerator;
    private final List<Car> cars;

    public Cars(NumberGenerator numberGenerator, List<Car> cars) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
    }

    void move() {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public Positions getPositions() {
        return new Positions(cars);
    }

    public Winners getWinners() {
        return new Winners(cars);
    }

    public int size() {
        return cars.size();
    }
}
