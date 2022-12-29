package racingcar.domain.collection;

import java.util.List;

public class GameResult {

    private final List<RaceRecord> raceRecords;

    public GameResult(List<RaceRecord> raceRecords) {
        this.raceRecords = raceRecords;
    }

    public List<RaceRecord> getRaceRecords() {
        return raceRecords;
    }

    public static GameResult of(List<RaceRecord> raceRecords) {
        return new GameResult(raceRecords);
    }
}
