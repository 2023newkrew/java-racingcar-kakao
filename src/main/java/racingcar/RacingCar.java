package racingcar;

public class RacingCar {

    private final String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 1;
    }

    public String getName() {
        return name;
    }

    public void move(boolean isMove) {
        if (!isMove) {
            return;
        }
        this.distance++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(" : ");
        for (int step = 0; step < distance; step++) {
            stringBuilder.append('-');
        }
        return stringBuilder.toString();
    }
}
