package racingcar.model;

import java.util.Random;

public class PowerGenerator {
    public static final int POWER_LIMIT = 10;
    private Random random;

    public PowerGenerator() {
        this.random = new Random();
    }

    public int getRandomPower() {
        return (int) random.nextInt(PowerGenerator.POWER_LIMIT);
    }
}
