package racingcar.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.CarDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingTest {
    private Racing racing;

    @BeforeEach
    void setUp() {
        this.racing = new Racing();
    }

    @Test
    void checkCarNos() {
        this.racing.makeCars(Arrays.asList("aa", "bbb", "ccc"));
        assertThat(this.racing.getCarDTOs().size()).isEqualTo(3);
    }

    @Test
    void duplicateNames() {
        assertThat(Racing.isDuplicateNames(Arrays.asList("aaa", "aaa"))).isTrue();
    }

    @Test
    void uniqueValidNames() {
        assertThat(Racing.isDuplicateNames(Arrays.asList("aaa", "aab"))).isFalse();
    }

    @Test
    void checkInvalidRace() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> racing.init("aa,bb,cc", "-1"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> racing.init("aa,bb,aa", "4"));
    }

    @Test
    void getWinners() {
        List<CarDTO> cars = new ArrayList<>();

        cars.add(new CarDTO("aa", 1));
        cars.add(new CarDTO("bb", 2));
        cars.add(new CarDTO("cc", 3));
        cars.add(new CarDTO("dd", 4));
        cars.add(new CarDTO("ee", 4));

        assertThat(Racing.getWinners(cars)).isEqualTo(Arrays.asList("dd", "ee"));
    }
}
