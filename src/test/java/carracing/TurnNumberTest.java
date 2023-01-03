package carracing;

import carracing.domain.TurnNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TurnNumberTest {
    @DisplayName("양수 검사 통과")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void turnNumberTest_validInput(int num) {
        //given
        //when
        //then
        Assertions.assertThatNoException().isThrownBy(() -> new TurnNumber(num));
    }

    @DisplayName("음수 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    void turnNumberTest_invalidInput(int num) {
        //given
        //when
        //then
        Assertions.assertThatRuntimeException().isThrownBy(() -> new TurnNumber(num));
    }

}