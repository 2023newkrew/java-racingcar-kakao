package racing.domain.car;

import org.jetbrains.annotations.NotNull;

public class Car implements Comparable<Car> {
    private final Name name;
    private int position;

    private static final int DEFAULT_POSITION = 0;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
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

    @Override
    public int compareTo(@NotNull Car car) {
        return this.position - car.position;
    }

    public boolean isEqualPosition(Car car) {
        return compareTo(car) == 0;
    }
}
