package racingcar.domain.model.impl;

import racingcar.domain.model.RacingCar;
import racingcar.exception.BusinessException;
import racingcar.exception.ErrorCode;
import racingcar.util.RandomUtil;

public class RacingCarImpl extends RacingCar {

    private static final int THRESHOLD = 4;

    private static final int RANDOM_NUMBER_MAXIMUM = 10;

    private static final int CAR_NAME_LIMIT = 5;

    public RacingCarImpl(String name) {
        super(name);
        checkCarNameLength(name);
    }

    @Override
    public void move() {
        if (canMove()) {
            super.position += 1;
        }
    }

    private boolean canMove() {
        return RandomUtil.generateRandomNumber(RANDOM_NUMBER_MAXIMUM) < THRESHOLD;
    }

    private void checkCarNameLength(String name) {
        if (name.length() > CAR_NAME_LIMIT) {
            throw new BusinessException(ErrorCode.TOO_LONG_CAR_NAME_EXCEPTION);
        }
    }
}
