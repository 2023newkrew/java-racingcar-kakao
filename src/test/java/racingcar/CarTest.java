package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void moveSuccess(){
        Car car = new Car("J", bound -> 4);
        boolean isMove = car.move();
        Assertions.assertThat(isMove).isTrue();
    }

    @Test
    void moveFail(){
        Car car = new Car("J", bound -> 3);
        boolean isMove = car.move();
        Assertions.assertThat(isMove).isFalse();
    }
}
