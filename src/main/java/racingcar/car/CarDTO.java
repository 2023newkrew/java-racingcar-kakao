package racingcar.car;

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

    @Override
    public String toString() {
        return this.name +
                ": " +
                "-".repeat(Math.max(0, this.position));
    }

    private final String name;
    private final int position;
}
