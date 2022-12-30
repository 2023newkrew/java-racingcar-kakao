package CarRacing.domain;

import java.util.List;

public class RacingResult {
    private List<RacingLog[]> racingLogs;
    private List<String> winners;

    public RacingResult(List<RacingLog[]> racingLogs, List<String> winners) {
        this.racingLogs = racingLogs;
        this.winners = winners;
    }

    public List<RacingLog[]> getRacingLogs() {
        return racingLogs;
    }

    public List<String> getWinners() {
        return winners;
    }
}
