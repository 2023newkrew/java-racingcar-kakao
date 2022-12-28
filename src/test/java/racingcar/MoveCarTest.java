package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MoveCarTest {

    @Test
    public void oneCarCanMove() {
        Car car = new Car();
        boolean canMove = car.canMove(4);
        car.moveOne(canMove);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
}



