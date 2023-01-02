package racingcar.domain;

import racingcar.domain.car.RacingCar;

class MockRacingCarImpl extends RacingCar {

    MockRacingCarImpl(String name) {
        super(name);
    }

    @Override
    public void move() {
        super.carPosition += 1;
    }
}
