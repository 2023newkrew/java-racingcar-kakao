package racingcar.domain;

public class RacingCar {
    public final static int POWER_THRESHOLD = 4;
    private final String name;
    private int pos;

    public RacingCar() {
        this("car");
    }

    public RacingCar(String name) {
        this.pos = 0;
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public int getPos() {
        return this.pos;
    }

    public void accelerate(int power) {
        if (power >= this.POWER_THRESHOLD) {
            this.pos += 1;
        }
    }
}
