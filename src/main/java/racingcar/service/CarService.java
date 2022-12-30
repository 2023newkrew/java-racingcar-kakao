package racingcar.service;

import racingcar.model.Car;
import racingcar.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Racing Game에 참가하는 Car객체들을 관리하는 클래스입니다.
 */
public class CarService {
    private final List<Car> cars;
    final static String NEW_LINE = "\n";

    public CarService() {
        cars = new ArrayList<>();
    }

    public void addAll(List<String> carNamesInput) {
        for (String carName : carNamesInput) {
            cars.add(new Car(carName));
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(RandomUtil.generateRandom());
        }
    }

    /**
     * 게임이 끝난 후 max position을 확인하고 그 max position에 있는 car들을 List로 반환
     *
     * @return max position에 있는 car들이 들어있는 리스트
     */
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
