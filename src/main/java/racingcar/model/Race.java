package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private static final int MAX_NAME_LIMIT = 5;
    private static final int MOVE_BOUNDARY = 4;

    private final List<Car> cars = new ArrayList<>();
    private int turn;

    public Race(String nameStr, int turn) {
        if (nameStr == null || nameStr.isBlank()) {
            throw new IllegalArgumentException("There should be at least 1 car name in string");
        }

        carInput(nameStr.split(","));
        this.turn = turn;
    }

    public void carInput(String[] nameSplit) {
        for (String name : nameSplit) {
            verifyName(name);
            cars.add(new Car(name));
        }
    }

    public void verifyName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("There should be at least 1 character for car name");
        }

        if (name.length() > MAX_NAME_LIMIT) {
            throw new IllegalArgumentException("Car name should be MAX_NAME_LIMIT or under");
        }
    }

    public void playTurn() {
        for (Car car : cars) {
            if (RandomMoveNumber.getRandomMoveNumber() >= MOVE_BOUNDARY) {
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
