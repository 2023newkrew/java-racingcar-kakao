package racingcar.domain;

import racingcar.domain.model.RacingCar;

class MockRacingCarImpl extends RacingCar {

    MockRacingCarImpl(String name) {
        super(name);
    }

    @Override
    public void move() {
        super.position += 1;
    }
}
