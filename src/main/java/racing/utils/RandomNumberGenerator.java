package racing.utils;

public class RandomNumberGenerator {
    private final int LOWER_BOUND = 0;
    private final int UPPER_BOUND = 9;

    public double generate() {
        return Math.random() * (UPPER_BOUND - LOWER_BOUND);
    }
}
