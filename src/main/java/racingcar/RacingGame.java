package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();
    private int turn;

    public RacingGame(List<String> carNameList, int turn) {
        for (String carName : carNameList) {
            this.carList.add(new Car(carName, 0));
        }
        this.turn = turn;
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
            maxPosition = makeWinnerList(car, maxPosition, winnerList);
        }

        return winnerList;
    }

    private int makeWinnerList(Car car, int maxPosition, List<String> winnerList) {
        if (car.getPosition() < maxPosition) return maxPosition;

        if (car.getPosition() > maxPosition) {
            winnerList.clear();
        }
        winnerList.add(car.getName());

        return car.getPosition();
    }

    private void playTurn() {
        for (Car car : carList) {
            car.moveCar();
        }
    }
}
