package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.ErrorCode;
import racing.exception.RacingException;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {
    @ParameterizedTest
    @ValueSource(strings = {"hello", "ccc"})
    @DisplayName("정상적인 차 이름 입력 테스트")
    void givenNormalCarName_whenCarNameValidate_thenOk(String input) {
        assertThatNoException().isThrownBy(() -> new Car(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "    "})
    @DisplayName("차 이름이 공백일 경우 테스트")
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
    @DisplayName("차 이름이 5글자를 초과하는 경우 테스트")
    void givenLongCarName_whenCarNameValidate_thenThrowException(String input){
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.TOO_LONG_CAR_NAME.getMessage());
    }
}
