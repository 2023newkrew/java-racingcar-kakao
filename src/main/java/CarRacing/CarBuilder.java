package CarRacing;

public class CarBuilder {
    private int position = 1;
    private String name;

    public CarBuilder() {}
    public Car buildCar() {
        return new Car(position, name);
    }

    public CarBuilder position(int position) {
        this.position = position;
        return this;
    }

    public CarBuilder name(String name) {
        this.name = name;
        return this;
    }
}
