package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();
    private int turn;
    private int maxPosition;

    public RacingGame(List<String> carNameList, int turn) {
        for (String carName : carNameList) {
            this.carList.add(new Car(carName, 0));
        }
        this.turn = turn;
        this.maxPosition = 0;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getTurn() {
        return turn;
    }

    public void play() {
        while (turn > 0) {
            playTurn();
            turn -= 1;
            OutputUI.printTurnResult(carList);
        }

        OutputUI.printGameResult(getWinners());
    }

    private List<String> getWinners() {
        int maxPosition = 0;
        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            maxPosition = checkIs1st(car, maxPosition, winnerList);
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
