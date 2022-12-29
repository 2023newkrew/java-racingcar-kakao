package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingGame {

    private final Referee referee;

    public RacingGame(String inputCarNames, int roundToPlay, NumberSelector numberSelector) {
        List<Car> registeredCars = registerCars(inputCarNames);
        this.referee = new Referee(roundToPlay, registeredCars, numberSelector);
    }

    private List<Car> registerCars(String inputCarNames) {
        String[] carNames = inputCarNames.split(",");
        List<Car> registeredCars = new ArrayList<>();
        for (String carName : carNames) {
            registeredCars.add(new Car(carName));
        }
        return registeredCars;
    }

    public List<String> announceWinners() {
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

    public Map<String, Integer> announceRoundResult() {
        return referee.announceRoundResult();
    }
}
