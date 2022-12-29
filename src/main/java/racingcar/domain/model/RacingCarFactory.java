package racingcar.domain.model;

import racingcar.domain.model.impl.RacingCarImpl;

public class RacingCarFactory {

    public static RacingCarImpl createRacingCar(String carName) {
        return new RacingCarImpl(carName);
    }
}
