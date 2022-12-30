package CarRacing.domain;

import CarRacing.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    List<RacingLog[]> racingLogs = new ArrayList<>();

    public Car[] makeCarList(String[] names) {
        Car[] cars = new Car[names.length];
        for (int index = 0; index < cars.length; index++) {
            cars[index] = new Car(names[index]);
        }
        return cars;
    }

    public int getMaxPosition(Car[] cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<String> getWinners(Car[] cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition(cars);
        for (Car car : cars) {
            String winnerName = car.getWinnerName(maxPosition);
            winners = addWinner(winners, winnerName);
        }
        return winners;
    }

    public List<String> addWinner(List<String> winners, String name) {
        if (name != null) {
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
        String[] names = StringUtil.splitString(inputNames, ",");
        return names;
    }

    public void writeRacingLog(Car[] cars) {
        RacingLog[] racingLog = new RacingLog[cars.length];
        for (int carIndex = 0; carIndex < cars.length; carIndex++) {
            racingLog[carIndex] = new RacingLog(cars[carIndex].getName(), cars[carIndex].getPosition());
        }
        racingLogs.add(racingLog);
    }

    public List<RacingLog[]> getRacingLogs() {
        return racingLogs;
    }

    public Car[] playRacing(Car[] cars, int tryCount) {
        writeRacingLog(cars);
        while (tryCount > 0) {
            cars = oneCycle(cars);
            writeRacingLog(cars);
            tryCount--;
        }
        return cars;
    }
}
