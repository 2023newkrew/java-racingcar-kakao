package CarRacing.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    public String[] splitInputString(String inputString) {
        return inputString.split(",");
    }

    public void checkCarNameLength(String name) {
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new RuntimeException("차 이름은 다섯 글자 이하여야 합니다.");
        }
    }

    public void checkCarsNameLength(String[] names) {
        for (String name : names) {
            checkCarNameLength(name);
        }
    }

    public Car[] makeCarList(String[] names) {
        Car[] cars = new Car[names.length];
        for (int index = 0; index < cars.length; index++) {
            cars[index] = new Car(names[index]);
        }
        return cars;
    }

    public List<String> getWinner(Car[] cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;
        for (int index = 0; index < cars.length; index++) {
            maxPosition = cars[index].getMaxPosition(maxPosition);
        }
        for (int index = 0; index < cars.length; index++) {
            String winnerName = cars[index].getWinnerName(maxPosition);
            winners = addWinner(winners, winnerName);
        }
        return winners;
    }

    public List<String> addWinner(List<String> winners, String name) {
        if(name != null) {
            winners.add(name);
        }
        return winners;
    }

    public Car[] oneCycle(Car[] cars) {
        for (Car car : cars) {
            car.carEvent();
        }
        return cars;
    }

    public String[] handleNames(String inputNames) {
        String[] names = splitInputString(inputNames);
        checkCarsNameLength(names);
        return names;
    }
}
