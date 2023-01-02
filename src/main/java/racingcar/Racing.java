package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final List<Car> cars = new ArrayList<>();
    private int roundNum;
    private final static int MAX_LENGTH = 5;

    boolean registerCarNames(final String input) {
        String[] temp = input.split(",");
        if (!checkLength(temp)) return false;

        for (String name : temp) {
            cars.add(new Car(name));
        }
        return true;
    }

    private boolean checkLength(final String[] nameList) {
        boolean check = true;
        for (String name : nameList) {
            check &= (name.length() <= MAX_LENGTH);
        }
        return check;
    }

    boolean registerCarRoundNum(final String input) {
        try {
            roundNum = Integer.parseInt(input);
            return roundNum > 0;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    boolean progressRound() {
        CarRandom random = new CarRandom();
        for (Car car : cars) {
            car.move(random.generateRandom10());
        }
        return true;
    }

    String roundResult() {
        String temp = "";
        for (Car car : cars) {
            temp += car.getName() + "," + car.getPosition() + ",";
        }
        return temp;
    }

    String getWinner() {
        int maxPosition = 0;
        String winnerList = "";
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        for (Car car : cars) {
            winnerList += car.matchPosition(maxPosition);
        }
        return winnerList;
    }

    int getRoundNum() {
        return roundNum;
    }
}
