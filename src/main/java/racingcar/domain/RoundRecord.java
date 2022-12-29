package racingcar.domain;

import racingcar.domain.dto.CarStatusDto;

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
