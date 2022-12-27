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

    @ValueSource(doubles = {0.1, 3.9, 2.2, 3.999})
    @ParameterizedTest
    void moveFalseTest(double number) {
        assertThat(car.move(number)).isEqualTo(false);
    }

    @ValueSource(doubles = {4.0, 5.0, 8.999})
    @ParameterizedTest
    void moveTrueTest(double number) {
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
