package racingcar.domain.dto;

import java.util.List;

public class GameResultDto {

    private final List<RaceRecordDto> raceRecords;

    public GameResultDto(List<RaceRecordDto> raceRecords) {
        this.raceRecords = raceRecords;
    }

    public List<RaceRecordDto> getRaceRecords() {
        return raceRecords;
    }

    public static GameResultDto of(List<RaceRecordDto> raceRecords) {
        return new GameResultDto(raceRecords);
    }
}
