package racingcar.model;

public class PowerGenerator {
    public static final int POWER_LIMIT = 10;

    public int getRandomPower() {
        return (int) (Math.random() * PowerGenerator.POWER_LIMIT)
                % PowerGenerator.POWER_LIMIT;
    }
}
