package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private final int THRESHOLD = 10;
    private final int BOUND = 4;

    @Test
    @DisplayName("Car가 이동하면 true를 반환한다.")
    void moveSuccess() {
        Car car = new Car("J");
        boolean isMove = car.move(new RandomMovable(THRESHOLD, BOUND) {
            @Override
            public boolean canMove() {
                return true;
            }
        });
        Assertions.assertThat(isMove).isTrue();
    }

    @Test
    @DisplayName("Car가 이동하지 않으면 false를 반환한다")
    void moveFail() {
        Car car = new Car("J");
        boolean isMove = car.move(new RandomMovable(THRESHOLD, BOUND) {
            @Override
            public boolean canMove() {
                return false;
            }
        });
        Assertions.assertThat(isMove).isFalse();
    }
}
