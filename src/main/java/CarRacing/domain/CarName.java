package CarRacing.domain;

import CarRacing.util.StringUtil;
import java.util.Objects;

public class CarName {
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    public void validateName(String name) {
        if (StringUtil.isBlank(name)) {
            throw new IllegalArgumentException("차 이름은 값이 존재해야 합니다.");
        }
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 " + MAXIMUM_CAR_NAME_LENGTH + "글자 이하여야 합니다.");
        }
        if (name.length() < MINIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 " + MINIMUM_CAR_NAME_LENGTH + "글자 이상이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
