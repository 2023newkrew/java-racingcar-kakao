package racingcar.model;

import java.util.List;

public class RoundResult {

    private final int round;
    private final List<Car> racingCars;

    public RoundResult(final int round, final List<Car> racingCars){
        this.round = round;
        this.racingCars = racingCars;
    }

    public int getRound() {
        return round;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}
