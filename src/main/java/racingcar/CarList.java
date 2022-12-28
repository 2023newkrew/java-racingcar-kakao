package racingcar;

import racingcar.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Racing Game에 참가하는 Car객체들을 관리하는 클래스입니다.
 * 구현한 모든 클래스가 조합되어 사용되는 부분
 */
public class CarList {
    private final List<Car> cars;
    final static String NEW_LINE = "\n";

    public CarList() {
        cars = new ArrayList<>();
    }

    public void add(Car newCar) {
        if (hasDuplicatedName(newCar)) {
            throw new RuntimeException();
        }
        cars.add(newCar);
    }

    private boolean hasDuplicatedName(Car other) {
        return cars.stream()
                .anyMatch(car -> car.equals(other));
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(RandomUtil.generateRandom());
        }
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        selectWinners(winners, maxPosition);
        return winners;
    }

    private void selectWinners(List<Car> winners, int maxPosition) {
        cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .forEach(winners::add);
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.toString() + NEW_LINE);
        }
        return stringBuilder.toString();
    }
}
