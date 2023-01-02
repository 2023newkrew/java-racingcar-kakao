package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> cars = new ArrayList<>();
    private int turn;

    public Race(String nameStr, int turn) {
        carInput(nameStr.split(","));
        this.turn = turn;
    }

    public void carInput(String[] nameSplit) {
        for (String name : nameSplit) {
            cars.add(new Car(name));
        }
    }

    public void playTurn() {
        for (Car car : cars) {
            if (CarMove.isMove()) {
                car.move();
            }
        }

        turn--;
    }

    public int raceMaxPosition() {
        int max = 0;

        for (Car car: cars) {
            max = Math.max(max, car.getPosition());
        }

        return max;
    }

    public String raceWinnerCheck(Car car, int max){
        if (car.getPosition() == max) {
            return car.getName() + ", ";
        }

        return "";
    }

    public String raceWinner() {
        int max = raceMaxPosition();
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            sb.append(raceWinnerCheck(car, max));
        }

        return sb.substring(0, sb.length() - 2);
    }

    public boolean isEnd() {
        return turn == 0;
    }

    public List<Car> getCars() {
        return cars;
    }
}
