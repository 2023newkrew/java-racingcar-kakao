package racingcar.domain.dto;

import racingcar.domain.collection.RacingCarCollection;

import java.util.List;
import java.util.stream.Collectors;

public class RaceRecordDto {

    private final List<RacingCarDto> cars;

    private RaceRecordDto(List<RacingCarDto> cars) {
        this.cars = cars;
    }

    public static RaceRecordDto of(RacingCarCollection cars) {
        return new RaceRecordDto(
                cars.getCars()
                        .stream()
                        .map(RacingCarDto::toDto)
                        .collect(Collectors.toList())
        );
    }

    public List<RacingCarDto> getCars() {
        return cars;
    }
}
