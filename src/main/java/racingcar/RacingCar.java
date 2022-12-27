package racingcar;

public class RacingCar {
    public final static int POWER_THRESHOLD = 4;
    private String name;
    private int pos;

    public RacingCar() {
        this.pos = 0;
    }
    public RacingCar(String name) {
        this();
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
