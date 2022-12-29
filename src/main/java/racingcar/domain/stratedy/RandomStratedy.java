package racingcar.domain.stratedy;

import racingcar.domain.Constants;

import java.util.Random;

public class RandomStratedy implements MovableStrategy {
    public boolean isMove() {
        return new Random().nextInt(Constants.RANDOM_MAX_NUM) >= Constants.FORWARD_NUM;
    }
}
