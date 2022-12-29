package racingcar.domain;

import java.util.List;
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
            int number = numberSelector.selectNumber();
            moveCar(car, number);
        }
        currentRound++;
    }

    private void moveCar(Car car, int number) {
        if (number >= MOVE_THRESHOLD) {
            car.move();
        }
    }

    public boolean isGameEnded() {
        return this.currentRound == this.roundToPlay;
    }

    public boolean isGamePlaying() {
        return this.currentRound < this.roundToPlay;
    }

    public List<Car> announceWinners() {
        int maxPosition = calculateMaxCarPosition();
        return this.registeredCars.stream()
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

    public List<Car> announceRoundResult() {
        return registeredCars;
    }

    public int getRoundToPlay() {
        return roundToPlay;
    }

    public int getCurrentRound() {
        return currentRound;
    }
}
