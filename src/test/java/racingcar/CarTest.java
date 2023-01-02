package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest

    public void moveTest(final int condition) {
        Car car = new Car("aaaa");
        car.move(condition);
        assertEquals(car.getPosition(), 1);
    }

    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    public void notMoveTest(final int condition) {
        Car car = new Car("aaaa");
        car.move(condition);
        assertEquals(car.getPosition(), 0);
    }

    @Test
    public void matchPositionTest() {
        Car car = new Car("aaa", 10);
        assertEquals(car.matchPosition(10), "aaa,");
    }

}
