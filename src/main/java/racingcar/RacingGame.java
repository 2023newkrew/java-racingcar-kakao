package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();
    private int turn;

    public RacingGame(String carList, int turn) {
        String[] carNameList = carList.split(",");
        for (String s : carNameList) {
            checkNameLength(s);
            this.carList.add(new Car(s));
        }
        this.turn = turn;
    }

    private void checkNameLength(String s) {
        if (s.length() > 5) throw new RuntimeException("5글자 이하의 이름만 가능합니다.");
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
        }
    }

    private void playTurn() {
        for (Car car : carList) {
            car.moveCar();
        }
    }
}
