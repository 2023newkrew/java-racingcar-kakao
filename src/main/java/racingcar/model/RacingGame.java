package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingGame {
    public static final int MAX_TRY_COUNT_LIMIT = 99;

    private final NumberGenerator numberGenerator;
    private final Cars cars;
    private final int maxTryCount;
    private int tryCount;

    public RacingGame(int maxTryCount, NumberGenerator numberGenerator, List<String> names) {
        if (hasDuplicatedName(names)) {
            throw new IllegalArgumentException("자동차 이름은 유일한 이름이어야 합니다.");
        }

        if (isInvalidTryCount(maxTryCount)) {
            throw new IllegalArgumentException("시도 회수는 " + MAX_TRY_COUNT_LIMIT + "이하의 숫자여야합니다.");
        }

        this.numberGenerator = numberGenerator;
        this.cars = createCars(names);
        this.maxTryCount = maxTryCount;
        this.tryCount = 0;
    }

    private static boolean isInvalidTryCount(int maxTryCount) {
        return maxTryCount > MAX_TRY_COUNT_LIMIT;
    }

    private boolean hasDuplicatedName(List<String> names) {
        Set<String> set = new HashSet<>(names);
        return set.size() != names.size();
    }

    private Cars createCars(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException();
        }

        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    public void moveCars() {
        if(isFinished()){
            throw new IllegalStateException();
        }

        cars.move(numberGenerator);
        tryCount++;
    }

    public boolean isFinished() {
        return tryCount >= maxTryCount;
    }

    public List<Car> getWinners() {
        if (isFinished()) {
            return cars.getWinnerCars();
        }
        throw new IllegalStateException("자동차 경주가 끝나지 않았습니다.");
    }

    public Positions getPositions() {
        return cars.getPositions();
    }
}
