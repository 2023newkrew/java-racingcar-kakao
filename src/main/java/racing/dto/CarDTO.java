package racing.dto;

public class CarDTO {
    private String name;
    private int distance;
    public CarDTO(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
