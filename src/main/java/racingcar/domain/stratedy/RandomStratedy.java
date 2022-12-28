package racingcar.domain.stratedy;

import java.util.Random;

public class RandomStratedy implements MovableStrategy {
    private final int FORWARD_NUM = 4;

    public boolean isMove() {
        return new Random().nextInt(10) >= FORWARD_NUM;
    }
}
