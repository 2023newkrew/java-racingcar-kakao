package racingcar.domain.dto;

import racingcar.domain.car.RacingCar;

public class RacingCarDto {

    private final int carPosition;

    private final String carName;

    public RacingCarDto(int carPosition, String carName) {
        this.carPosition = carPosition;
        this.carName = carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public static RacingCarDto toDto(RacingCar racingCar) {
        return new RacingCarDto(racingCar.getCarPosition(), racingCar.getCarName());
    }
}
