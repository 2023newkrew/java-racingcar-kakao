package racingcar.domain;

import java.util.Random;

public class RamdomMovable implements Movable {

    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean isMovable() {
        return pickRandomNumber() > MOVE_THRESHOLD;
    }

    private int pickRandomNumber() {
        return new Random().nextInt(10);
    }
}
