package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingServiceTest {
    @Test
    void getWinners() {
        List<CarDTO> cars = new ArrayList<>();

        cars.add(new CarDTO("aa", 1));
        cars.add(new CarDTO("bb", 2));
        cars.add(new CarDTO("cc", 3));
        cars.add(new CarDTO("dd", 4));
        cars.add(new CarDTO("ee", 4));

        RacingService racingService = new RacingService();

        assertThat(racingService.getWinners(cars)).isEqualTo(Arrays.asList("dd", "ee"));
    }
}
