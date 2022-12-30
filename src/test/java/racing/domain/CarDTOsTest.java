package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.dto.CarDTOs;
import racing.dto.CarDtoDistanceComparator;

public class CarDTOsTest {
    @DisplayName("CarDTOs에서 우승자들의 CarName을 선별한다.")
    @ParameterizedTest
    @MethodSource("generator")
    void CarDTOs에서_우승자들의_CarName을_선별한다(List<String> names, List<String> winners, List<Integer> positions) {
        List<Car> cars = names.stream()
                .map(name -> new Car(new CarName(name), new Position(positions.get(names.indexOf(name)))))
                .collect(Collectors.toList());
        assertThat(CarDTOs.of(cars).getWinners(new CarDtoDistanceComparator()))
                .isEqualTo(winners.stream().map(CarName::new).collect(Collectors.toList()));
    }

    private static Stream<Arguments> generator() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("pobi", "crong", "honux", "kyne"),
                        Arrays.asList("pobi", "kyne"),
                        Arrays.asList(5, 4, 3, 5)),
                Arguments.of(
                        Arrays.asList("pobi", "crong", "honux", "kyne"),
                        Arrays.asList("kyne"),
                        Arrays.asList(5, 4, 3, 15)),
                Arguments.of(
                        Arrays.asList("pobi", "crong", "honux", "kyne"),
                        Arrays.asList("pobi", "crong", "honux", "kyne"),
                        Arrays.asList(5, 5, 5, 5)));
    }
}
