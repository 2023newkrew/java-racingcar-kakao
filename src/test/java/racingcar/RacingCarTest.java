package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingCar;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {
    @ParameterizedTest(name = "power : {0}")
    @DisplayName("전진 기능 테스트 : 이동하지 않음")
    @ValueSource(ints={1,2,3})
    public void not_move(final int power) {
        //given
        RacingCar car = new RacingCar();

        //when, then
        car.accelerate(power);
        assertEquals(0, car.getPos());
    }

    @ParameterizedTest(name = "power : {0}")
    @DisplayName("전진 기능 테스트 : 이동")
    @ValueSource(ints={4,5,6})
    public void move(final int power) {
        //given
        RacingCar car = new RacingCar();

        //when, then
        car.accelerate(power);
        assertEquals(1, car.getPos());
    }
}
