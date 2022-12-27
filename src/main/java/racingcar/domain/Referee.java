package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Referee {

    public static final int MOVE_THRESHOLD = 4;

    private final int roundToPlay;
    private int currentRound;
    private final List<Car> registeredCars;
    private final NumberSelector numberSelector;

    public Referee(int roundToPlay, List<Car> registeredCars, NumberSelector numberSelector) {
        validateRoundToPlay(roundToPlay);
        this.roundToPlay = roundToPlay;
        this.currentRound = 0;
        this.registeredCars = registeredCars;
        this.numberSelector = numberSelector;
    }

    private void validateRoundToPlay(int roundToPlay) {
        if (roundToPlay < 0) {
            throw new IllegalArgumentException("라운드는 양수여야 합니다.");
        }
    }

    public void moveCars() {
        for (Car car : registeredCars) {
            int selectedNumber = numberSelector.selectNumber();
            moveOrStay(car, selectedNumber);
        }
        currentRound++;
    }

    private void moveOrStay(Car car, int selectedNumber) {
        if (selectedNumber >= MOVE_THRESHOLD) {
            car.move();
            return;
        }
        car.stay();
    }

    public boolean isGameEnd() {
        return this.currentRound == this.roundToPlay;
    }

    public List<String> announceWinners() {
        int maxPosition = calculateMaxCarPosition();
        return this.registeredCars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int calculateMaxCarPosition() {
        int maxPosition = 0;
        for (Car car : registeredCars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public Map<String, Integer> announceRoundResult() {
        Map<String, Integer> roundResult = new LinkedHashMap<>();
        for (Car car : registeredCars) {
            roundResult.put(car.getCarName(), car.getPosition());
        }
        return roundResult;
    }

    public int getRoundToPlay() {
        return roundToPlay;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public List<Car> getRegisteredCars() {
        return registeredCars;
    }
}
