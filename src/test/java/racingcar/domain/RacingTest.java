package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing();
        racing.setCount(4);
        racing.addCars(Arrays.asList(
                new Car("davi", () -> true, 0),
                new Car("sean", () -> false, 5)
        ));
    }

    @Test
    void 레이싱에_자동차를_추가한다() {
        assertThat(racing.getCarList()).hasSize(2);
        assertThat(racing.getCarList().get(0).getName()).isEqualTo("davi");
        assertThat(racing.getCarList().get(1).getName()).isEqualTo("sean");
        assertThat(racing.getCarList().get(0).getDistance()).isEqualTo(0);
        assertThat(racing.getCarList().get(1).getDistance()).isEqualTo(5);
    }

    @Test
    void 레이싱의_차들이_전진을_시도한다() {
        racing.tryForward();
        assertThat(racing.getCarList().get(0).getDistance()).isEqualTo(1);
        assertThat(racing.getCarList().get(1).getDistance()).isEqualTo(5);
    }

    @Test
    void 레이싱_종료후_결과를_반환한다() {
        while (!racing.isFinished()) {
            racing.tryForward();
        }

        assertThat(racing.getCount()).isEqualTo(0);
        assertThat(racing.winner()).containsOnly("sean");
    }
}
