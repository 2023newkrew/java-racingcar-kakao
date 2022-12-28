package racingcar.model;

import java.util.List;

class Cars {

    private final NumberGenerator numberGenerator;
    private final List<Car> cars;

    Cars(NumberGenerator numberGenerator, List<Car> cars) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
    }

    void move() {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    Positions getPositions() {
        return new Positions(cars);
    }

    Winners getWinners() {
        return new Winners(cars);
    }

    public int size() {
        return cars.size();
    }
}
