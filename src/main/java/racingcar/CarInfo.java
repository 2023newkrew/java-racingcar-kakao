package racingcar;

public class CarInfo {
    private final String name;
    private final int position;

    public static CarInfo of(String name, int position) {
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
}
