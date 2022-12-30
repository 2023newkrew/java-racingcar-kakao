package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final String CAR_NAME_DELIMITER = ",";

    private final int roundToPlay;
    private int currentRound;
    private final List<Car> registeredCars;
    private final NumberSelector numberSelector;

    public RacingGame(String inputCarNames, int roundToPlay, NumberSelector numberSelector) {
        validateRoundToPlay(roundToPlay);
        this.roundToPlay = roundToPlay;
        this.currentRound = 0;
        this.registeredCars = registerCars(inputCarNames);
        this.numberSelector = numberSelector;
    }

    private void validateRoundToPlay(int roundToPlay) {
        if (roundToPlay < 0) {
            throw new IllegalArgumentException("라운드는 양수여야 합니다.");
        }
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
        int maxPosition = calculateMaxCarPosition();
        return registeredCars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int calculateMaxCarPosition() {
        int maxPosition = 0;
        for (Car car : registeredCars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public void proceedRound() {
        if (isGameEnded()) {
            throw new IllegalArgumentException("게임이 종료되었습니다.");
        }
        for (Car car : registeredCars) {
            int number = numberSelector.selectNumber();
            car.move(number);
        }
        currentRound++;
    }

    public boolean isGameEnded() {
        return currentRound == roundToPlay;
    }

    public boolean isGamePlaying() {
        return currentRound < roundToPlay;
    }

    public List<Car> announceRoundResult() {
        return registeredCars;
    }
}
