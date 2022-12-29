package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void init() {
        cars = new Cars(Arrays.asList("pobi", "crong", "honux", "cosmo", "kyne"));
    }

    @Test
    void 한명의_우승자가_발생하는_경우() {
        cars.play(List.of(0.1, 0.3, 2.9, 8.8, 1.4));
        assertThat(cars.getWinners()).isEqualTo(Arrays.asList("cosmo"));
    }

    @Test
    void 두명의_우승자가_발생하는_경우() {
        cars.play(List.of(0.1, 0.3, 2.9, 8.8, 4.4));
        cars.play(List.of(0.1, 5.3, 2.9, 7.0, 6.4));
        assertThat(cars.getWinners()).isEqualTo(Arrays.asList("cosmo", "kyne"));
    }
}
