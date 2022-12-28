package racingcar.domain;

import java.util.Random;

public class RandomNumberSelector implements NumberSelector {

    private final Random random;

    public RandomNumberSelector() {
        this.random = new Random();
    }

    public int selectNumber() {
        return random.nextInt(10);
    }
}
