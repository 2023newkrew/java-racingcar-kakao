package racingcar;

public class CarDto {

    private String name;
    private int position;

    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto of(String name, int distance) {
        return new CarDto(name, distance);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
