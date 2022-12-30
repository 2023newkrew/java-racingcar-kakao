package CarRacing.domain;

import CarRacing.util.StringUtil;
import CarRacing.util.wrongInputCountException;
import java.util.ArrayList;
import java.util.List;


public class Racing {
    private int racingCount;
    private Car[] cars;

    private List<RacingLog[]> racingLogs = new ArrayList<>();
    private List<String> winners = new ArrayList<>();


    public Racing(String inputNames, String racingCount) {
        validateRacingCount(racingCount);
        this.racingCount = StringUtil.convertStringToInt(racingCount);

        makeCarList(splitInputNames(inputNames));
    }

    public void validateRacingCount(String racingCount) {
        try {
            StringUtil.convertStringToInt(racingCount);
        } catch (NumberFormatException e) {
            //throw new wrongInputCountException("숫자가 아닌 입력입니다.");
            throw new RuntimeException("숫자가 아닌 입력입니다.");
        }
    }

    public String[] splitInputNames(String inputNames) {
        return StringUtil.splitString(inputNames, ",");
    }

    public void makeCarList(String[] names) {
        cars = new Car[names.length];
        for (int index = 0; index < cars.length; index++) {
            cars[index] = new Car(names[index]);
        }
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public void decideWinners() {
        int maxPosition = getMaxPosition();
        for (Car car : cars) {
            String winnerName = car.getWinnerName(maxPosition);
            addWinner(winnerName);
        }
    }

    public void addWinner(String name) {
        if (name != null) {
            winners.add(name);
        }
    }

    public void oneCycle() {
        for (Car car : cars) {
            car.carEvent();
        }
    }


    public void writeRacingLog() {
        RacingLog[] racingLog = new RacingLog[cars.length];
        for (int carIndex = 0; carIndex < cars.length; carIndex++) {
            racingLog[carIndex] = new RacingLog(cars[carIndex].getName(), cars[carIndex].getPosition());
        }
        racingLogs.add(racingLog);
    }

    public List<RacingLog[]> getRacingLogs() {
        return racingLogs;
    }

    public RacingResult playRacing() {
        writeRacingLog();
        while (racingCount> 0) {
            oneCycle();
            writeRacingLog();
            racingCount--;
        }
        decideWinners();
        return new RacingResult(racingLogs, winners);
    }
}
