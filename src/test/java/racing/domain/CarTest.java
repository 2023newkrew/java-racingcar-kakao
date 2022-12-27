package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarTest {

    private Car car;

    @BeforeAll
    void init() {
        car = new Car();
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
}
