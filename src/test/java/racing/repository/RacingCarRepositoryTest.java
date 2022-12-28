package racing.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.model.Car;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarRepositoryTest {
    @ParameterizedTest
    @MethodSource("carListGenerator")
    void Car_리스트가_주어졌을때_가장_멀리간_Car의_이름을_담은_리스트를_반환(List<Car> cars, List<String> expected){
        RacingCarRepository.init(cars);
        assertThat(RacingCarRepository.getWinners()).hasSameElementsAs(expected);

    }

    private static Stream<Arguments> carListGenerator(){
        return Stream.of(
                Arguments.of(List.of(new Car("aaa", 3), new Car("bbb", 1), new Car("ccc", 2)), List.of("aaa")),
                Arguments.of(List.of(new Car("aaa", 1), new Car("bbb", 1), new Car("ccc", 2)), List.of("ccc")),
                Arguments.of(List.of(new Car("aaa", 3), new Car("bbb", 3), new Car("ccc", 2)), List.of("aaa", "bbb")),
                Arguments.of(List.of(new Car("aaa", 2), new Car("bbb", 5), new Car("ccc", 3)), List.of("bbb")),
                Arguments.of(List.of(new Car("aaa", 3), new Car("bbb", 3), new Car("ccc", 3)), List.of("aaa", "bbb", "ccc"))
        );
    }
}
