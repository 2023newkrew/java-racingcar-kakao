package racingcar.domain.dto;

import racingcar.domain.model.RacingCar;

public class CarStatusDto {

    private final String carName;

    private final Integer carPosition;

    public CarStatusDto(String carName, Integer carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public Integer getCarPosition() {
        return carPosition;
    }

    public static CarStatusDto toDto(RacingCar racingCar) {
        return new CarStatusDto(racingCar.getName(), racingCar.getPosition());
    }
}
