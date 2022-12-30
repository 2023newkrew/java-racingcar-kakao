package racingcar.domain.racing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    void checkCarNos() {
        RacingCar racingCar = new RacingCar(Arrays.asList("aa", "bb", "cc"));

        assertThat(racingCar.getCarDTOs().size()).isEqualTo(3);
    }

    @Test
    void duplicateNames() {
        assertThat(RacingCar.isDuplicateNames(Arrays.asList("aaa", "aaa"))).isTrue();
    }

    @Test
    void uniqueValidNames() {
        assertThat(RacingCar.isDuplicateNames(Arrays.asList("aaa", "aab"))).isFalse();
    }
}
