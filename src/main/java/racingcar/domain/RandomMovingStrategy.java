package racingcar.domain;

import racingcar.util.RandomGenerator;

public class RandomMovingStrategy implements MovingStrategy{
    private static final int FORWARD_THRESHOLD = 4;
    @Override
    public MoveState getMoveState() {
        if (RandomGenerator.getRandomNumber() < FORWARD_THRESHOLD)
            return MoveState.STOP;
        return  MoveState.FORWARD;
    }
}
