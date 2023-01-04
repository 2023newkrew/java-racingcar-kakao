package racingcar.service.dto;

import racingcar.domain.Car;

import java.util.Objects;

public class CarResponse {

    private String name;
    private int position;

    public CarResponse(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static CarResponse of(Car car) {
        return new CarResponse(car.getName(), car.getPosition());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CarResponse that = (CarResponse) o;
        return position == that.position && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
