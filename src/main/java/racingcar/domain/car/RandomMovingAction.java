package racingcar.domain.car;

import racingcar.util.RandomGenerator;

public class RandomMovingAction implements MovingAction {
    private final int THRESHOLD = 4;

    @Override
    public CarAction getAction() {
        if (RandomGenerator.generateOneDigit() >= THRESHOLD)
            return CarAction.FORWARD;

        return CarAction.STAY;
    }
}