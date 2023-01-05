package racingcar.domain;

import racingcar.dto.CarInfo;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private final List<CarInfo> carStatusList;

    public GameResult(List<CarInfo> carStatusList) {
        this.carStatusList = carStatusList;
    }

    public List<CarInfo> getCarStatusList() {
        return carStatusList;
    }

    public String getIntermediateResult() {
        StringBuilder result = new StringBuilder();

        for (CarInfo carStatus : carStatusList) {
            result.append(String.format("%s : %s\n", carStatus.getName(), "-".repeat(carStatus.getPosition())));
        }

        return result.toString();
    }

    public String getFinalResult() {
        String winners = carStatusList.stream()
                .map(CarInfo::getName)
                .collect(Collectors.joining(", "));

        return String.format("%s가 최종 우승했습니다.", winners);
    }
}