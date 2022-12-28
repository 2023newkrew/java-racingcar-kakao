package racing.repository;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.exception.ErrorCode;
import racing.exception.RacingException;
import racing.model.Car;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarRepositoryTest {

    @ParameterizedTest
    @MethodSource("carListGenerator")
    void Car_리스트가_주어졌을때_가장_멀리간_Car의_이름을_담은_리스트를_반환(List<Car> cars, List<String> expected){
        //given
        RacingCarRepository racingCarRepository = new RacingCarRepository(cars);

        //when & then
        assertThat(racingCarRepository.getWinners()).hasSameElementsAs(expected);
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
    @MethodSource("blankCarNameListGenerator")
    public void Car_이름으로_빈문자열이_입력되면_예외를_반환(List<Car> input){
        //given
        //when & then
        assertThatThrownBy(() -> new RacingCarRepository(input))
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.EMPTY_CAR_NAME.getMessage());
    }

    private static Stream<List<Car>> blankCarNameListGenerator(){
        return Stream.of(
                List.of(new Car("", 3), new Car("", 1)),
                List.of(new Car("   ", 1), new Car("   ", 1))
        );
    }

    @ParameterizedTest
    @MethodSource("LongCarNameListGenerator")
    public void 다섯자_이상의_Car_이름이_입력되면_예외를_반환(List<Car> input){
        //given
        //when & then
        assertThatThrownBy(() -> new RacingCarRepository(input))
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.TOO_LONG_CAR_NAME.getMessage());
    }
    private static Stream<List<Car>> LongCarNameListGenerator(){
        return Stream.of(
                List.of(new Car("verylongcarname", 3)),
                List.of(new Car("sixsix", 1))
        );
    }
}
