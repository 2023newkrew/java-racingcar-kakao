package racingcar.domain.car;

import racingcar.exception.BusinessException;
import racingcar.exception.ErrorCode;
import racingcar.util.StringUtil;

import java.util.Objects;

public abstract class RacingCar {

    protected int carPosition = 1;

    protected final String carName;

    public RacingCar(String carName) {
        validateNotEmptyOrNull(carName);
        this.carName = carName;
    }

    public abstract void move();

    public String getCarName() {
        return carName;
    }

    public Integer getCarPosition() {
        return carPosition;
    }

    private void validateNotEmptyOrNull(String name) {
        if (StringUtil.isEmpty(name)) {
            throw new BusinessException(ErrorCode.EMPTY_CAR_NAME_EXCEPTION);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar that = (RacingCar) o;
        return carName.equals(that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
