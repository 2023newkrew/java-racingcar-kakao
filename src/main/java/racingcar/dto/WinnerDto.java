package racingcar.dto;

import java.util.List;

public class WinnerDto {
    private final List<String> winners;

    public WinnerDto(List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinners() {
        return winners;
    }
}
