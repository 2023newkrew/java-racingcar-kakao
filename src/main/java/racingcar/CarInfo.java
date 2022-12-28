package racingcar;

import java.util.Objects;

public class CarInfo {
    private final String name;
    private final int position;

    public static CarInfo from(String name, int position) {
        return new CarInfo(name, position);
    }

    private CarInfo(String name, int position) {
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
        CarInfo carInfo = (CarInfo) o;
        return position == carInfo.position && Objects.equals(name, carInfo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
