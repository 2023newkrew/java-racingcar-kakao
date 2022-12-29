package racingcar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class InputTest {
    @DisplayName("null & empty 입력 예외 테스트")
    @NullAndEmptySource
    @ParameterizedTest
    void nullAndEmptyExceptionTest(String input){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            InputUI.validateCarList(Arrays.asList("123", "345", input));
        });
    }

    @DisplayName("턴 입력 예외 테스트")
    @ValueSource(strings = {"abc", "1a", ""})
    @ParameterizedTest
    void inputTurnExceptionTest(String input){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            InputUI.validationTurn(input);
        });
    }
}
