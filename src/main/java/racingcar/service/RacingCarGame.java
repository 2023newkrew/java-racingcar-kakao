package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Movable;
import racingcar.domain.RandomNumberMovable;
import racingcar.view.FinalResult;
import racingcar.view.RoundResult;

import java.util.List;

public class RacingCarGame {

    private Cars cars;
    private int round;
    private Movable movable;

    public RacingCarGame(List<Car> cars, int gameRound, Movable movable) {
        this.cars = new Cars(cars);
        this.round = gameRound;
        this.movable = movable;
    }

    public RoundResult doNextRound() {
        cars.moveAll(movable);
        round -= 1;

        return new RoundResult(cars.toCarResponses());
    }

    public FinalResult selectWinners() {
        return new FinalResult(cars.selectWinners());
    }

    public boolean isFinish() {
        return round == 0;
    }
}
