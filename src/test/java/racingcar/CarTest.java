package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private static Field distance;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException {
        distance = RacingCar.class.getDeclaredField("distance");
        distance.setAccessible(true);
    }

    @Test
    public void moveTest() throws IllegalAccessException {
        Car racingCar = new RacingCar("abc");
        racingCar.move(5);
        int dist = (int) distance.get(racingCar);
        assertThat(dist).isEqualTo(1);
    }

    @Test
    public void doNotMoveTest() throws IllegalAccessException {
        Car racingCar = new RacingCar("abc");
        racingCar.move(2);
        int dist = (int) distance.get(racingCar);
        assertThat(dist).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "def"})
    public void toStringTest(String input) {
        Car racingCar = new RacingCar(input);
        for (int i = 0; i < 3; i++) {
            racingCar.move(5);
            assertThat(racingCar.toString()).isEqualTo(input + " : " +"-".repeat(i+1));
        }
    }




}
