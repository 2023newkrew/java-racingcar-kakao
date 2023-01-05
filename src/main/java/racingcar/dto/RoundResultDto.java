package racingcar.dto;

import racingcar.model.Car;

import java.util.List;

public class RoundResultDto {
    private final List<Car> carState;

    public RoundResultDto(List<Car> carState) {
        this.carState = carState;
    }

    public List<Car> getCarState() {
        return carState;
    }
}
