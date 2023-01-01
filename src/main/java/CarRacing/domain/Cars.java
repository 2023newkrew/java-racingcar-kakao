package CarRacing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private Car[] cars;

    public Cars(String[] names) {
        validateCarNamesLength(names.length);
        cars = new Car[names.length];
        for (int index = 0; index < names.length; index++) {
            cars[index] = new Car(names[index]);
        }
    }

    public Cars(Car[] cars) {
        this.cars = cars;
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

    public List<CarName> getWinners(CarPosition maxPosition) {
        List<CarName> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.isWinner(maxPosition)){
                winners.add(car.getCarName());
            }
        }

        return winners;
    }

    public void oneCycle() {
        for (Car car : cars) {
            car.carEvent();
        }
    }

    public RacingLog[] getRacingLog() {
        RacingLog[] racingLog = new RacingLog[cars.length];
        for (int carIndex = 0; carIndex < cars.length; carIndex++) {
            racingLog[carIndex] = new RacingLog(cars[carIndex].getCarName(), cars[carIndex].getPosition());
        }

        return racingLog;
    }
}
