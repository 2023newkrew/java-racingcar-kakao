package racingcar.step2.domain;

import java.util.List;

public class RacingGame {

    private static final String ERR_TURN_MUST_BE_POSITIVE = "시도 횟수는 0보다 커야 합니다.";

    private final Cars cars;
    private int turn;

    public RacingGame(List<String> carNames, int turn) {
        this.cars = new Cars(carNames);

        if (turn < 0) {
            throw new IllegalArgumentException(ERR_TURN_MUST_BE_POSITIVE);
        }
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
