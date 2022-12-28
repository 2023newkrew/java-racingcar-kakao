package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        car = new Car("");
    }

    @ValueSource(ints = {0, 3, 2, 1})
    @ParameterizedTest
    void moveFalseTest(int number) {
        assertThat(car.move(number)).isEqualTo(false);
    }

    @ValueSource(ints = {4, 5, 8, 9})
    @ParameterizedTest
    void moveTrueTest(int number) {
        assertThat(car.move(number)).isEqualTo(true);
    }

    @Test
    void compareDistanceTest(){
        Car opponent = new Car("123");
        assertThat(opponent.compareTo(car)).isEqualTo(0);
        assertThat(car.compareTo(opponent)).isEqualTo(0);

        opponent.move(5);
        assertThat(opponent.compareTo(car)).isGreaterThan(0);
        assertThat(car.compareTo(opponent)).isLessThan(0);
    }
}
