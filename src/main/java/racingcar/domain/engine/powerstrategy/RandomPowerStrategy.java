package racingcar.domain.engine.powerstrategy;

import java.util.Random;

public class RandomPowerStrategy implements PowerStrategy {

    private static final Random random = new Random();
    private final int maxPower;

    public static PowerStrategy from(int maxPower) {
        checkMaxPowerValidation(maxPower);
        return new RandomPowerStrategy(maxPower);
    }

    private static void checkMaxPowerValidation(int maxPower) {
        if (maxPower < 0) {
            throw new RuntimeException("Max power greater then 0.");
        }
    }

    private RandomPowerStrategy(int maxPower) {
        this.maxPower = maxPower;
    }

    @Override
    public int getPower() {
        return random.nextInt(maxPower);
    }
}
