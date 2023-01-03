package racingcar.step2.domain;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private int turn;

    public RacingGame(List<String> carNames, int turn) {
        this.cars = new Cars(carNames);
        this.turn = turn;
    }

    public Cars getCars() {
        return cars;
    }

    public boolean isEnd() {
        return turn == 0;
    }

    public void playTurn() {
        cars.moveAll();
        turn--;
    }

    public List<String> getWinners() {
        int maxPosition = cars.getMaxPosition();
        return cars.selectWinners(maxPosition);
    }
}
