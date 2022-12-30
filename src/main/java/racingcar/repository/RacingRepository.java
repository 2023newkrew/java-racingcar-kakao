package racingcar.repository;

import racingcar.service.RacingCars;

public class RacingRepository {
    private final RacingCars cars;

    public RacingRepository(RacingCars cars) {
        this.cars = cars;
    }

    public RacingCars getCars() {
        return cars;
    }
}
