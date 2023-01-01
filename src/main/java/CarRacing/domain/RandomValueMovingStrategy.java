package CarRacing.domain;

public class RandomValueMovingStrategy implements MovingStrategy {
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MOVE_THRESHOLD = 4;
    private NumberGenerator numberGenerator;

    public RandomValueMovingStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
    @Override
    public boolean movable() {
        return generateRandomNumber() >= MOVE_THRESHOLD;
    }

    private int generateRandomNumber() {
        return numberGenerator.generateNumber(RANDOM_NUMBER_RANGE);
    }
}
