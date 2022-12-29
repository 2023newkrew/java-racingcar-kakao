package racingcar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.ui.InputUI;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class InputTest {
    @DisplayName("차량 이름 null & empty 입력 예외 테스트")
    @NullAndEmptySource
    @ParameterizedTest
    void nullAndEmptyExceptionTest(String input){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            InputUI.validateCarList(Arrays.asList("123", "345", input));
        });
    }

    @DisplayName("차량 이름 입력 글자 수 예외 테스트")
    @ValueSource(strings = {"글자수제한넘음", "다섯글자넘음", "aaaaaaa"})
    @ParameterizedTest
    void maxLengthExceptionTest(String input){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            InputUI.validateCarList(Arrays.asList("123", "345", input));
        });
    }

    @DisplayName("턴 입력 예외 테스트")
    @ValueSource(strings = {"abc", "1a", ""})
    @ParameterizedTest
    void inputTurnExceptionTest(String input){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            InputUI.validateTurn(input);
        });
    }
}
