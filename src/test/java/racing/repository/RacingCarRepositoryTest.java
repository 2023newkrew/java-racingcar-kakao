package racing.repository;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racing.exception.ErrorCode;
import racing.exception.RacingException;
import racing.model.Car;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarRepositoryTest {


    @ParameterizedTest
    @MethodSource("blankCarNameListGenerator")
    public void Car_이름으로_빈문자열이_입력되면_예외를_반환(List<Car> input){
        //given
        //when & then
        assertThatThrownBy(() -> RacingCarRepository.saveCars(input))
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
        assertThatThrownBy(() -> RacingCarRepository.saveCars(input))
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
