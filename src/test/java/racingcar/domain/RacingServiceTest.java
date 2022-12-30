package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.CarDTO;

public class RacingServiceTest {

    private RacingService racingService;

    @BeforeEach
    void setUp() {
        racingService = new RacingService();
    }

    @Test
    void getWinners() {
        List<CarDTO> cars = new ArrayList<>();

        cars.add(new CarDTO("aa", 1));
        cars.add(new CarDTO("bb", 2));
        cars.add(new CarDTO("cc", 3));
        cars.add(new CarDTO("dd", 4));
        cars.add(new CarDTO("ee", 4));

        assertThat(this.racingService.getWinners(cars)).isEqualTo(Arrays.asList("dd", "ee"));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void shouldNotMove(int no) {
        assertThat(this.racingService.getActionResult(no)).isEqualTo(CarAction.STAY);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void shouldMove(int no) {
        assertThat(this.racingService.getActionResult(no)).isEqualTo(CarAction.FORWARD);
    }
}
