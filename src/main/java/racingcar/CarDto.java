package racingcar;

import java.util.Objects;

public class CarDto {

    private final String name;

    private final int position;

    public static CarDto from(String name, int position) {
        return new CarDto(name, position);
    }

    private CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDto carDto = (CarDto) o;
        return position == carDto.position && Objects.equals(name, carDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
