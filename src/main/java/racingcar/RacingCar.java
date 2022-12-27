package racingcar;

public class RacingCar {
    public final static int POWER_THRESHOLD = 4;
    private int pos;

    public int getPos() {
        return this.pos;
    }

    public void accelerate(int power) {
        if (power >= this.POWER_THRESHOLD) {
            this.pos += 1;
        }
    }
}
