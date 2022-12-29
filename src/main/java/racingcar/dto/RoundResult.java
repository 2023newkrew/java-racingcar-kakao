package racingcar.dto;

import java.util.List;

public class RoundResult {

    private List<CarDto> carStatusList;

    public RoundResult(List<CarDto> carStatusList) {
        this.carStatusList = carStatusList;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (CarDto carStatus : carStatusList) {
            result.append(String.format("%s : %s\n", carStatus.getName(), "-".repeat(carStatus.getPosition())));
        }

        return result.toString();
    }

}
