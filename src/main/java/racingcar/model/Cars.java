package racingcar.model;

import racingcar.util.RandomUtil;

import java.util.*;

/**
 * Racing Game에 참가하는 Car객체들을 관리하는 클래스입니다.
 */
public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNamesInput) {
        checkDuplicatedCarName(carNamesInput);
        cars = new ArrayList<>();
        addAll(carNamesInput);
    }

    private void checkDuplicatedCarName(List<String> carNameList) {
        if (hasDuplicatedName(carNameList)) {
            throw new IllegalArgumentException("Duplicated Car Name!");
        }
    }

    private boolean hasDuplicatedName(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        return carNameSet.size() < carNameList.size();
    }

    public void addAll(List<String> carNamesInput) {
        for (String carName : carNamesInput) {
            add(new Car(carName));
        }
    }

    public void add(Car car) {
        cars.add(car);
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

    public final List<Car> getCarList() {
        return Collections.unmodifiableList(cars);
    }
}
