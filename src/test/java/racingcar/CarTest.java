package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("Car가 이동할 때")
    void moveSuccess(){
        Car car = new Car("J");
        boolean isMove = car.move(bound -> 4);
        Assertions.assertThat(isMove).isTrue();
    }

    @Test
    @DisplayName("Car가 이동하지 않을 때")
    void moveFail(){
        Car car = new Car("J");
        boolean isMove = car.move(bound -> 3);
        Assertions.assertThat(isMove).isFalse();
    }
}
