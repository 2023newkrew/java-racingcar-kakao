package CarRacing;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    public String[] nameSplit(String inputString) {
        return inputString.split(",");
    }

    public void nameException(String name) {
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new RuntimeException("다섯 글자 이상입니다.");
        }
    }

    public void nameExceptions(String[] names) {
        for (int index = 0; index < names.length; index++) {
            nameException(names[index]);
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
        for (int index = 0; index < cars.length; index++) {
            cars[index].carEvent();
        }
        return cars;
    }

    public String[] handleNames(String inputNames) {
        String[] names = nameSplit(inputNames);
        nameExceptions(names);
        return names;
    }
}
