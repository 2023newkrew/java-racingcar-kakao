package mvc.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Game {
    private final List<Car> carList;
    private final int totalTurn;
    private int curTurn;

    public Game(List<Car> carList, int totalTurn) {
        this.carList = carList;
        this.totalTurn = totalTurn;
        this.curTurn = 0;
    }

    public boolean isEnd() {
        return curTurn == totalTurn;
    }

    public void playOneTurn() {
        for (Car car : carList) {
            car.move();
        }
        curTurn++;
    }

    public List<Car> findWinners() {
        int winnerPosition = extractWinnerPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : carList) {
            addCarIfWinner(winners, car, winnerPosition);
        }
        return winners;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int extractWinnerPosition() {
        Car oneOfWinners = Collections.max(carList, Comparator.comparing(car -> car.getPosition()));
        return oneOfWinners.getPosition();
    }

    private void addCarIfWinner(List<Car> winners, Car car, int winnerPosition) {
        if (car.getPosition() == winnerPosition) {
            winners.add(car);
        }
    }
}
