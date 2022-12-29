package racingcar.domain.car;

import racingcar.domain.car.impl.RacingCarImpl;

public class RacingCarFactory {

    public static RacingCarImpl createRacingCar(String carName) {
        return new RacingCarImpl(carName);
    }
}
