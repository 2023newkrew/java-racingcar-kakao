package racingcar;

import java.util.List;

public class RoundRecord {

    private final List<CarStatusDto> carStatusDtoList;

    public RoundRecord(List<CarStatusDto> carStatusDtoList) {
        this.carStatusDtoList = carStatusDtoList;
    }

    public List<CarStatusDto> getCarStatusList() {
        return carStatusDtoList;
    }
}
