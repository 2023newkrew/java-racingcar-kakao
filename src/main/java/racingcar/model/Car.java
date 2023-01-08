package racingcar.model;

public class Car {
    public final static int POWER_THRESHOLD = 4;
    private final CarName name;
    private int distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = 0;
    }

    public String getName() {
        return this.name.get();
    }

    public int getDistance() {
        return this.distance;
    }

    public void accelerate(int power) {
        if (power >= this.POWER_THRESHOLD) {
            this.distance += 1;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.getName());
        sb.append(" : ");
        for (int i = 0; i <= this.distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
