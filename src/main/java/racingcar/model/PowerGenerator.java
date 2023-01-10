package racingcar.model;

public class PowerGenerator {
    private static final int POWER_LIMIT = 10;
    private PowerGenerationStrategy strategy;

    public int generatePower() {
        return this.strategy.generatePower(PowerGenerator.POWER_LIMIT);
    }

    public void setPowerGenerationStrategy(PowerGenerationStrategy strategy) {
        this.strategy = strategy;
    }
}
