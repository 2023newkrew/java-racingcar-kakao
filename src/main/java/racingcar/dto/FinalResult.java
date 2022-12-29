package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;

public class FinalResult {

    private List<CarDto> carStatusList;

    public FinalResult(List<CarDto> carStatusList) {
        this.carStatusList = carStatusList;
    }

    public String toString() {
        String winners = carStatusList.stream()
                .map(CarDto::getName)
                .collect(Collectors.joining(", "));

        return String.format("%s가 최종 우승했습니다.", winners);
    }
}
