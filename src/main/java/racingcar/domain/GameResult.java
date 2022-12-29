package racingcar.domain;

import java.util.List;

public class GameResult {

    private final List<RoundRecord> roundRecords;

    public GameResult(List<RoundRecord> roundRecords) {
        this.roundRecords = roundRecords;
    }

    public List<RoundRecord> getRoundRecords() {
        return roundRecords;
    }
}
