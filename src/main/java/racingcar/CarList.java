package racingcar;

import racingcar.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class CarList {
    /**
     * Racing Game에 참가하는 Car객체들을 관리하는 클래스입니다.
     * 구현한 모든 클래스가 조합되어 사용되는 부분
     */
    private final List<Car> cars;

    public CarList() {
        cars = new ArrayList<>();
    }

    public void add(Car other) {
        if (hasDuplicatedName(other)) {
            throw new RuntimeException();
        }
        cars.add(other);
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

    public List<Car> selectWinners() {
        List<Car> winners = new ArrayList<>();
        OptionalInt maxPosition = getMaxPosition();
        getWinners(winners, maxPosition);
        return winners;
    }

    private void getWinners(List<Car> winners, OptionalInt maxPosition) {
        cars.stream()
                .filter(car -> car.getPosition() == maxPosition.getAsInt())
                .forEach(winners::add);
    }

    private OptionalInt getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.toString() + "\n");
        }
        return stringBuilder.toString();
    }
}
