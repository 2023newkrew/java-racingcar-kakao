package racing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.model.Car;
import racing.repository.RacingCarRepository;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingServiceTest {

    @BeforeEach
    void setUp(){
        RacingCarRepository.deleteAll();
    }

    @ParameterizedTest
    @MethodSource("carListGenerator")
    void 가장_멀리간_Car의_이름을_담은_리스트를_반환(List<Car> cars, List<String> expected){
        //given
        RacingCarRepository.saveCars(cars);
        RacingService racingService = new RacingService();

        //when & then
        assertThat(racingService.getWinnerCarNames())
                .hasSameElementsAs(expected);
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

    @ParameterizedTest
    @MethodSource("carListAndStatusGenerator")
    void Car의_상태문자열을_담은_리스트를_반환(List<Car> cars, List<String> expected){
        //given
        RacingCarRepository.saveCars(cars);
        RacingService racingService = new RacingService();

        //when & then
        assertThat(racingService.getCarStatusStrings())
                .hasSameElementsAs(expected);
    }

    private static Stream<Arguments> carListAndStatusGenerator(){
        return Stream.of(
                Arguments.of(List.of(new Car("aaa", 3), new Car("bbb", 1), new Car("ccc", 2)), List.of("aaa : ---","bbb : -", "ccc : --")),
                Arguments.of(List.of(new Car("aaa"), new Car("bbb"), new Car("ccc")), List.of("aaa : -","bbb : -", "ccc : -"))
        );
    }



}
