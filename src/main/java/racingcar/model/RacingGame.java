package racingcar.model;

import racingcar.Constant.StringConstant;

import java.util.List;

/**
 * 컨트롤러의 비즈니스로직을 최소화하기 위한 모델과 컨트롤러 사이의 서비스 레이어 개념을 생각하고 만들었습니다.
 * trial number만큼 racing을 진행하는 for문 로직이 있습니다.
 * 전체 게임 로그를 유지하여 컨트롤러에 넘겨줍니다.
 */
public class RacingGame {
    private final int trial;
    private final Cars cars;
    private final StringBuilder gameLog;

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

    public final String gameLog() {
        return gameLog.toString();
    }

    public List<Car> winners() {
        return cars.getWinners();
    }
}
