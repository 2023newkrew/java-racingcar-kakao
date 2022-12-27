package racingcar.domain;

import racingcar.dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private List<CarDto> carStatusList;

    public GameResult(List<CarDto> carStatusList) {
        this.carStatusList = carStatusList;
    }

    public List<CarDto> getCarStatusList() {
        return carStatusList;
    }

    public String getIntermediateResult() {
        StringBuilder result = new StringBuilder();

        for (CarDto carStatus : carStatusList) {
            result.append(String.format("%s : %s\n", carStatus.getName(), "-".repeat(carStatus.getPosition())));
        }

        return result.toString();
    }

    public String getFinalResult() {
        String winners = carStatusList.stream()
                .map(CarDto::getName)
                .collect(Collectors.joining(", "));

        return String.format("%s가 최종 우승했습니다.", winners);
    }
}
