package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.dto.CarDTO;
import racing.dto.CarDtoDistanceComparator;

public class CarsTest {
    private Cars cars;
    private Comparator<CarDTO> distanceComparator;
    @BeforeEach
    void init() {
        cars = new Cars(Arrays.asList("pobi", "crong", "honux", "cosmo", "kyne").stream().map(CarName::new).collect(
                Collectors.toList()));
        distanceComparator = new CarDtoDistanceComparator();
    }

    @Test
    void singleWinnerTest() {
        cars.play();
        assertThat(cars.getWinners(distanceComparator)).isEqualTo(Arrays.asList("cosmo"));
    }

    @Test
    void multiWinnerTest() {
        cars.play();
        cars.play();
        assertThat(cars.getWinners(distanceComparator)).isEqualTo(Arrays.asList("cosmo", "kyne"));
    }
}
