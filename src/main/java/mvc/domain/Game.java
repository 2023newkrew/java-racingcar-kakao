package mvc.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Game {
    private final List<Car> carList;
    private final int totalTurn;

    public Game(List<Car> carList, int totalTurn) {
        this.carList = carList;
        this.totalTurn = totalTurn;
    }

    public int extractWinnerScore() {
        Car oneOfWinners = Collections.max(carList, Comparator.comparing(car -> car.getPosition()));
        return oneOfWinners.getPosition();
    }
}
