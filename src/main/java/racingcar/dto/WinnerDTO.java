package racingcar.dto;

import racingcar.domain.Car;

public class WinnerDTO {

    private final String name;

    public WinnerDTO(String name) {
        this.name = name;
    }

    public static WinnerDTO from(Car car) {
        return new WinnerDTO(car.getName());
    }

    @Override
    public String toString() {
        return name + " ";
    }
}
