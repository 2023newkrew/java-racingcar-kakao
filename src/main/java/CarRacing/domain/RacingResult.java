package CarRacing.domain;

import java.util.List;

public class RacingResult {
    private List<RacingLog[]> racingLogs;
    private List<CarName> winners;

    public RacingResult(List<RacingLog[]> racingLogs, List<CarName> winners) {
        this.racingLogs = racingLogs;
        this.winners = winners;
    }

    public List<RacingLog[]> getRacingLogs() {
        return racingLogs;
    }

    public List<CarName> getWinners() {
        return winners;
    }
}
