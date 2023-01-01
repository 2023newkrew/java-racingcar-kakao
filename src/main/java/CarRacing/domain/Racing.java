package CarRacing.domain;

import CarRacing.util.StringUtil;
import java.util.ArrayList;
import java.util.List;


public class Racing {
    private int racingCount;
    private Car[] cars;
    private List<RacingLog[]> racingLogs = new ArrayList<>();
    private List<CarName> winners = new ArrayList<>();


    public Racing(String inputNames, String racingCount) {
        validateRacingCount(racingCount);
        this.racingCount = StringUtil.convertStringToInt(racingCount);

        makeCarList(splitInputNames(inputNames));
    }

    public Racing(Car[] cars, int racingCount) {
        this.cars = cars;
        this.racingCount = racingCount;
    }

    public void validateRacingCount(String racingCount) {
        try {
            StringUtil.convertStringToInt(racingCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수 입력이 숫자가 아닙니다.");
        }
    }

    public String[] splitInputNames(String inputNames) {
        return StringUtil.splitString(inputNames, ",");
    }

    public void makeCarList(String[] names) {
        validateCarNamesLength(names.length);
        cars = new Car[names.length];
        for (int index = 0; index < cars.length; index++) {
            cars[index] = new Car(names[index]);
        }
    }

    public void validateCarNamesLength(int carNamesLength) {
        if (carNamesLength == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력하십시오.");
        }
    }

    public CarPosition getMaxPosition() {
        CarPosition maxPosition = new CarPosition(0);
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public void decideWinners() {
        CarPosition maxPosition = getMaxPosition();
        for (Car car : cars) {
            if(car.isWinner(maxPosition)){
                addWinner(car.getCarName());
            }
        }
    }

    public void addWinner(CarName name) {
        winners.add(name);
    }

    public void oneCycle() {
        for (Car car : cars) {
            car.carEvent();
        }
    }

    public void writeRacingLog() {
        RacingLog[] racingLog = new RacingLog[cars.length];
        for (int carIndex = 0; carIndex < cars.length; carIndex++) {
            racingLog[carIndex] = new RacingLog(cars[carIndex].getCarName(), cars[carIndex].getPosition());
        }
        racingLogs.add(racingLog);
    }

    public RacingResult playRacing() {
        writeRacingLog();
        while (racingCount > 0) {
            oneCycle();
            writeRacingLog();
            racingCount--;
        }
        decideWinners();
        return new RacingResult(racingLogs, winners);
    }

    public Car[] getCarList() {
        return cars;
    }

    public List<CarName> getWinners() {
        return winners;
    }
}
