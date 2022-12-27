package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {
    @Test
    @DisplayName("전진 정지 기능 테스트")
    public void move() {
        //given
        Car car = new Car();

        //when, then
        car.accelerate(Car.POWER_THRESHOLD-1);
        assertEquals(0, car.getPos());
        car.accelerate(Car.POWER_THRESHOLD);
        assertEquals(1, car.getPos());
    }

}
