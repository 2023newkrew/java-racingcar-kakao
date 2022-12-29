package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.RacingCar;

public class CarTest {


    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    public void moveTest(int input) throws IllegalAccessException {
        Car racingCar = new RacingCar("abc");
        racingCar.move(input);
        int dist = racingCar.getDistance();
        assertThat(dist).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void doNotMoveTest(int input) throws IllegalAccessException {
        Car racingCar = new RacingCar("abc");
        racingCar.move(input);
        int dist = racingCar.getDistance();
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
