package racingcar.domain.dto;

import racingcar.domain.model.RacingCar;

public class CarWinnerDto {

    private final String name;

    public CarWinnerDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CarWinnerDto toDto(RacingCar car) {
        return new CarWinnerDto(car.getName());
    }
}
