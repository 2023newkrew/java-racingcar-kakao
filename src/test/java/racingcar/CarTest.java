package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    public void 자동차가_움직인다() {
        Car car = new Car("aaaa");
        assertEquals(car.move(true), 1);
    }

    @Test
    public void 자동차가_정지한다() {
        Car car = new Car("aaaa");
        assertEquals(car.move(false), 0);
    }
}
