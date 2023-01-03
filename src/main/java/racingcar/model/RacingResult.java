package racingcar.model;

import java.util.List;

public class RacingResult {

    private final List<RoundResult> roundResults;
    private final List<Car> winnerCars;

    public RacingResult(List<RoundResult> roundResults, List<Car> winnerCars){
        this.roundResults = roundResults;
        this.winnerCars = winnerCars;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public List<Car> getWinnerCars() {
        return winnerCars;
    }
}
