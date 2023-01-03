package racingcar.model;

import racingcar.exception.RacingException;
import racingcar.exception.RacingExceptionCode;
import racingcar.util.Movable;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCarGroup {
    private final List<RacingCar> cars;
    private static final int CARS_SIZE_LOWER_LIMIT = 2;
    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    public RacingCarGroup(List<RacingCar> cars) {
        this.cars = cars;
    }

    public RacingCarGroup(String[] carNames) {
        validateCarNames(carNames);
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new RacingCar(carName));
        }
    }

    public void validateCarNames(String[] carNames) {
        validateCarNumber(carNames);
        for (String carName : carNames) {
            validateLength(carName);
        }
        validateDuplication(carNames);
    }
    public void moveCars(Movable movable) {
        for (Car car : cars) {
            car.move(movable);
        }
    }

    public List<RacingCar> getWinners() {
        RacingCar winner = cars.stream().max(Comparator.comparingInt(RacingCar::getPosition)).orElse(null);
        return cars.stream()
                .filter(car -> car.getPosition() == winner.getPosition())
                .collect(Collectors.toList());
    }

    public List<RacingCar> getCarsList() {
        return Collections.unmodifiableList(cars);
    }

    private  void validateCarNumber(String[] carNames) {
        if (carNames.length < CARS_SIZE_LOWER_LIMIT) {
            throw new RacingException(RacingExceptionCode.INVALID_CARS_SIZE);
        }
    }

    private  void validateLength(String inputStr) {
        if (inputStr.length() > CAR_NAME_LENGTH_LIMIT || inputStr.length() == 0) {
            throw new RacingException(RacingExceptionCode.INVALID_CAR_LENGTH);
        }
    }

    private  void validateDuplication(String[] inputStr) {
        Set<String> carNames = new HashSet<>(Arrays.asList(inputStr));
        if (carNames.size() != inputStr.length) {
            throw new RacingException(RacingExceptionCode.CAR_NAME_DUPLICATION);
        }
    }
}
