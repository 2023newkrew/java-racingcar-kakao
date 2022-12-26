package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        assertThat(dist).isEqualTo(1);
    }

    @Test
    public void doNotMoveTest() throws IllegalAccessException {
        Car car = new Car("abc");
        car.move(2);
        int dist = (int) distance.get(car);
        assertThat(dist).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "def"})
    public void toStringTest(String input) {
        Car car = new Car(input);
        for (int i = 0; i < 3; i++) {
            car.move(5);
            assertThat(car.toString()).isEqualTo(input + " : " +"-".repeat(i+1));
        }
    }




}
