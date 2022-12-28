package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void moveSuccess(){
        Car car = new Car("J");
        boolean isMove = car.move(bound -> 4);
        Assertions.assertThat(isMove).isTrue();
    }

    @Test
    void moveFail(){
        Car car = new Car("J");
        boolean isMove = car.move(bound -> 3);
        Assertions.assertThat(isMove).isFalse();
    }
}
