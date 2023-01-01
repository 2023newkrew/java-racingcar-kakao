package racing.domain;

import java.util.Random;

public class RandomlyMove implements Move {

    private final static int MAX_VALUE = 10;
    private final static int THRESHOLD = 4;

    @Override
    public boolean movable() {
        return createRandomNumber() >= THRESHOLD;
    }

    private int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_VALUE);
    }

}
