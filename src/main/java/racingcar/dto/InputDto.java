package racingcar.dto;

import java.util.List;

public class InputDto {
    private final List<String> carNames;
    private final int roundNum;

    public InputDto(List<String> carNames, int roundNum) {
        this.carNames = carNames;
        this.roundNum = roundNum;
    }
    public List<String> getCarNames() {
        return carNames;
    }

    public int getRoundNum() {
        return roundNum;
    }

}
