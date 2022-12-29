package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domian.Car;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Method determineToMove;

    @BeforeEach
    void setUp() throws NoSuchMethodException {
        determineToMove = Car.class.getDeclaredMethod("determineToMove", int.class);

        determineToMove.setAccessible(true);
    }

    @Test
    void stopTest() throws InvocationTargetException, IllegalAccessException {
        Car car = new Car("test", 0);

        determineToMove.invoke(car, 3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void moveTest() throws InvocationTargetException, IllegalAccessException {
        Car car = new Car("test", 0);

        determineToMove.invoke(car, 4);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
