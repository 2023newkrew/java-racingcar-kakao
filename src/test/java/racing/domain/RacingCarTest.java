package racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.ErrorCode;
import racing.exception.RacingException;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {
    @ParameterizedTest
    @ValueSource(strings = {"hello", "ccc"})
    void givenNormalCarName_whenCarNameValidate_thenOk(String input) {
        assertThatNoException().isThrownBy(() -> new Car(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "    "})
    void givenNullOrEmptyCarName_whenCarNameValidate_thenThrowException(String input){
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.EMPTY_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "verylongcarname",
            "sixsix",
    })
    void givenLongCarName_whenCarNameValidate_thenThrowException(String input){
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.TOO_LONG_CAR_NAME.getMessage());
    }
}
