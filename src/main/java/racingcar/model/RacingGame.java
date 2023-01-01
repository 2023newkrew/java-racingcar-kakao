package racingcar.model;

import racingcar.Constant.StringConstant;

import java.util.List;

public class RacingGame {
    private final int trial;
    private final Cars cars;
    private StringBuilder gameLog;

    public RacingGame(int trial_input, List<String> carNamesInput) {
        validateTrialUserInput(trial_input);
        trial = trial_input;
        cars = new Cars(carNamesInput);
        gameLog = new StringBuilder();
        initGameLog();
    }

    public int validateTrialUserInput(int trialNumber) {
        checkNegative(trialNumber);
        return trialNumber;
    }

    private void checkNegative(int trialNumber) {
        if (trialNumber < 0) {
            throw new IllegalArgumentException("Negative number is not allowed");
        }
    }

    private void initGameLog() {
        gameLog.append("실행 결과" + StringConstant.NEW_LINE);
        gameLog.append(cars + StringConstant.NEW_LINE);
    }

    public void runRacingGame() {
        for (int round = 0; round < trial; round++) {
            cars.moveAll();
            gameLog.append(cars);
            gameLog.append(StringConstant.NEW_LINE);
        }
    }

    public String gameLog() {
        return gameLog.toString();
    }

    public List<Car> winners() {
        return cars.getWinners();
    }
}
