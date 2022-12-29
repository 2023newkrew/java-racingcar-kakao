package racing.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.ErrorCode;
import racing.exception.RacingException;
import racing.model.Car;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    @ParameterizedTest
    @ValueSource(strings = {"hello", "ccc"})
    public void givenNormalCarName_whenCarNameValidate_thenOk(String input) {
        assertThatNoException().isThrownBy(() -> new Car(input, 1));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "    "})
    public void givenNullOrEmptyCarName_whenCarNameValidate_thenThrowException(String input){
        assertThatThrownBy(() -> new Car(input, 1))
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.EMPTY_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "verylongcarname",
            "sixsix",
    })
    public void givenLongCarName_whenCarNameValidate_thenThrowException(String input){
        assertThatThrownBy(() -> new Car(input, 1))
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.TOO_LONG_CAR_NAME.getMessage());
    }
}
