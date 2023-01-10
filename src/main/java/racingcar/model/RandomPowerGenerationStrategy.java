package racingcar.model;

import java.util.Random;

public class RandomPowerGenerationStrategy implements PowerGenerationStrategy {
    private final Random random = new Random();

    public int generatePower(int range) {
        return random.nextInt(range);
    }
}
