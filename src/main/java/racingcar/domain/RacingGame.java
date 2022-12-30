package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final String CAR_NAME_DELIMITER = ",";

    private final Referee referee;

    public RacingGame(String inputCarNames, int roundToPlay, NumberSelector numberSelector) {
        List<Car> registeredCars = registerCars(inputCarNames);
        this.referee = new Referee(roundToPlay, registeredCars, numberSelector);
    }

    private List<Car> registerCars(String inputCarNames) {
        String[] carNames = inputCarNames.split(CAR_NAME_DELIMITER);
        return Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public List<Car> announceWinners() {
        if (isGamePlaying()) {
            throw new IllegalArgumentException("아직 게임이 종료되지 않았습니다.");
        }
        return referee.announceWinners();
    }

    public boolean isGameEnded() {
        return referee.isGameEnded();
    }

    public boolean isGamePlaying() {
        return referee.isGamePlaying();
    }

    public void proceedRound() {
        referee.moveCars();
    }

    public List<Car> announceRoundResult() {
        return referee.announceRoundResult();
    }
}
