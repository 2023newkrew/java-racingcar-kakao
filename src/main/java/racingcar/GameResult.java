package racingcar;

import java.util.List;

public class GameResult {

    private List<CarDto> carStatusList;

    public GameResult(List<CarDto> carStatusList) {
        this.carStatusList = carStatusList;
    }

    public List<CarDto> getCarStatusList() {
        return carStatusList;
    }

    public String getIntermediateResult() {
        return null;
    }

    public String getFinalResult() {
        return null;
    }

}
