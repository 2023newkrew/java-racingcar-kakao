package racingcar.domain.collection;

import racingcar.domain.dto.RacingCarDto;

import java.util.List;
import java.util.stream.Collectors;

public class RaceRecord {

    private final List<RacingCarDto> cars;

    private RaceRecord(List<RacingCarDto> cars) {
        this.cars = cars;
    }

    public static RaceRecord of(RacingCarCollection cars) {
        return new RaceRecord(
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
