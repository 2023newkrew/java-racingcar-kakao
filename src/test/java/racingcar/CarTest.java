package racingcar;

import java.lang.reflect.Field;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CarTest {

    private static Field distance;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException {
        distance = Car.class.getDeclaredField("distance");
        distance.setAccessible(true);
    }

    @Test
    public void moveTest() throws IllegalAccessException {
        Car car = new Car("abc");
        car.move(5);
        int dist = (int) distance.get(car);
        Assertions.assertThat(dist).isEqualTo(1);
    }

    @Test
    public void doNotMoveTest() throws IllegalAccessException {
        Car car = new Car("abc");
        car.move(2);
        int dist = (int) distance.get(car);
        Assertions.assertThat(dist).isEqualTo(0);
    }
}
