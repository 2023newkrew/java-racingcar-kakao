package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void init() {
        cars = new Cars("pobi,crong,honux,cosmo,kyne");
    }

    @Test
    void 자동차_이름이_중복될_수_없다() {
        assertThatThrownBy(() -> new Cars("pobi,pobi,cosmo,kyne"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 한명의_우승자가_발생하는_경우() {
        cars.play(List.of(0, 1, 2, 8, 3));
        assertThat(cars.getWinners()).isEqualTo(Arrays.asList("cosmo"));
    }

    @Test
    void 두명의_우승자가_발생하는_경우() {
        cars.play(List.of(0, 1, 2, 8, 4));
        cars.play(List.of(0, 5, 2, 7, 6));
        assertThat(cars.getWinners()).isEqualTo(Arrays.asList("cosmo", "kyne"));
    }
}
