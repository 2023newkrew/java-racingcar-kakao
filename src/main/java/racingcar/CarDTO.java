package racingcar;

public class CarDTO {
    public CarDTO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private final String name;
    private final int position;
}
