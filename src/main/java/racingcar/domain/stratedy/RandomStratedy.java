package racingcar.domain.stratedy;

import java.util.Random;

import static racingcar.domain.Constants.*;

public class RandomStratedy implements MovableStrategy {
    public boolean isMove() {
        return new Random().nextInt(RANDOM_MAX_NUM) >= FORWARD_NUM;
    }
}
