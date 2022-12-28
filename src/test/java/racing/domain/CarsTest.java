package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    public void setUp() {
        cars = new Cars();
    }

    @Test
    public void isMove() {
        assertThat(cars.isMove(4)).isEqualTo(true);
        assertThat(cars.isMove(9)).isEqualTo(true);
    }

    @Test
    public void isStop() {
        assertThat(cars.isMove(0)).isEqualTo(false);
        assertThat(cars.isMove(3)).isEqualTo(false);
    }

}
