package racingcar.model;

import java.util.*;
import java.util.stream.Collectors;

import static racingcar.model.RacingConstant.*;

public class RacingGame {
    private final NumberGenerator numberGenerator;
    private final Cars racingCars;
    private final int maxRound;
    private int currentRound;

    public RacingGame(int maxRound, NumberGenerator numberGenerator, List<String> racingCarNames) {
        if (hasDuplicatedName(racingCarNames)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION_MSG);
        }

        if (isInvalidRound(maxRound)) {
            throw new IllegalArgumentException(MAX_ROUND_OUT_OF_RANGE_EXCEPTION_MSG);
        }

        this.numberGenerator = numberGenerator;
        this.racingCars = createCars(racingCarNames);
        this.maxRound = maxRound;
        this.currentRound = 1;
    }

    private boolean hasDuplicatedName(List<String> names) {
        Set<String> set = new HashSet<>(names);
        return set.size() != names.size();
    }

    private static boolean isInvalidRound(int maxRound) {
        return maxRound > MAX_ROUND_LIMIT;
    }

    private Cars createCars(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException(NUMBER_OF_PARTICIPATING_CARS_EXCEPTION_MSG);
        }

        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    public RacingResult start() {
        if(isRaceFinished()){
            throw new IllegalStateException(ALREADY_CLOSED_RACE_EXCEPTION_MSG);
        }

        return race();
    }

    private RacingResult race() {
        List<RoundResult> roundResults = new ArrayList<>();
        while(currentRound <= maxRound){
            racingCars.move(numberGenerator);
            roundResults.add(new RoundResult(currentRound, racingCars.deepCopy()));
            currentRound++;
        }

        List<Car> winnerCars = racingCars.getWinnerCars();
        return new RacingResult(roundResults, new Cars(winnerCars).deepCopy());
    }

    private boolean isRaceFinished(){
        return currentRound > maxRound;
    }
}
