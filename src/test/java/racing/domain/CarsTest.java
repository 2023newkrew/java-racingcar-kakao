package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    public void setUp() {
        cars = new Cars();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 자동차는_4_이상의_숫자에서_움직입니다(int number) {
        assertThat(cars.isMove(number)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 자동차는_3_이하의_숫자에서는_움직이지_않습니다(int number) {
        assertThat(cars.isMove(number)).isEqualTo(false);
    }

}
