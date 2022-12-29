package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 값이_4_이상일_경우_한_칸_전진한다(final int condition) {
        Car car = new Car("aaaa");
        assertEquals(car.move(condition), 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 값이_3_이하일_경우_정지한다(final int condition) {
        Car car = new Car("aaaa");
        assertEquals(car.move(condition), 0);
    }
}
