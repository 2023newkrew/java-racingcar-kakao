package racingcar.dto;

public class CarInfo {

    private final String name;
    private final int position;

    public CarInfo(String name) {
        this(name, 1);
    }

    public CarInfo(String name, int position) {
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