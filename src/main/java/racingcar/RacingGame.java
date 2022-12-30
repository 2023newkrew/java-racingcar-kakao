package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingGame {
    private final List<Car> carList;
    private int turn;
    private int maxPosition;

    public RacingGame(List<Car> carList, int turn) {
        this.carList = carList;
        this.turn = turn;
        carList.stream()
                .map(Car::getPosition)
                .max(Comparator.comparingInt(c -> c))
                .ifPresent(mp -> this.maxPosition = mp);
    }

    public List<String> play() {
        while (turn > 0) {
            playTurn();
            turn -= 1;
            OutputUI.printTurnResult(carList);
        }

        return getWinners();
    }

    private List<String> getWinners() {
        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            checkIs1st(car, winnerList);
        }

        return winnerList;
    }

    private void checkIs1st(Car car, List<String> winnerList) {
        if (car.getPosition() == maxPosition)
            winnerList.add(car.getName());
    }

    private void playTurn() {
        for (Car car : carList) {
            maxPosition = Math.max(maxPosition,
                    car.moveCar(RandomNumGenerator.makeRandomNumber(10)));
        }
    }
}
