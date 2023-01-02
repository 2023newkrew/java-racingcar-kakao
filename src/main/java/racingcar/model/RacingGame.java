package racingcar.model;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    public static final int MAX_ROUND_LIMIT = 99;

    private final NumberGenerator numberGenerator;
    private final Cars racingCars;
    private final int maxRound;
    private int currentRound;

    public RacingGame(int maxRound, NumberGenerator numberGenerator, List<String> racingCarNames) {
        if (hasDuplicatedName(racingCarNames)) {
            throw new IllegalArgumentException("자동차 이름은 유일한 이름이어야 합니다.");
        }

        if (isInvalidRound(maxRound)) {
            throw new IllegalArgumentException("시도 회수는 " + MAX_ROUND_LIMIT + "이하의 숫자여야합니다.");
        }

        this.numberGenerator = numberGenerator;
        this.racingCars = createCars(racingCarNames);
        this.maxRound = maxRound;
        this.currentRound = 1;
    }

    private static boolean isInvalidRound(int maxRound) {
        return maxRound > MAX_ROUND_LIMIT;
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

    public RacingResult race() {
        List<RoundResult> roundResults = new ArrayList<>();

        while(currentRound <= maxRound){
            racingCars.move(numberGenerator);
            roundResults.add(new RoundResult(currentRound, racingCars.deepCopy()));
            currentRound++;
        }

        List<Car> winnerCars = racingCars.getWinnerCars();
        return new RacingResult(roundResults, new Cars(winnerCars).deepCopy());
    }
}
