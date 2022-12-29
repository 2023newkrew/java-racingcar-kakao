package racing.domain;

public class Car {
    private final Name name;
    private int position;

    private static final int DEFAULT_POSITION = 0;

    public Car(String name) {
        this.name = new Name(name);
        this.position = DEFAULT_POSITION;
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }
}
