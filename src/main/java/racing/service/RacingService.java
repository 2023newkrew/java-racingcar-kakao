package racing.service;

import racing.model.Car;

import java.util.List;

public class RacingService {
    public void turn(List<Car> cars) {
        for (Car car : cars) {
            car.tryMove();
        }
    }
}
