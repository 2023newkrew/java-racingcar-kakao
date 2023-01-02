package carracing;

import carracing.domain.InputVerifier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputVerifierTest {
    @DisplayName("양수 검사 통과")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void verifyNumberIsPos_validInput(int num) {
        //given
        //when
        //then
        Assertions.assertThatNoException().isThrownBy(() -> InputVerifier.verifyNumberIsPos(num));
    }

    @DisplayName("음수 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void verifyNumberIsPos_invalidInput(int num) {
        //given
        //when
        //then
        Assertions.assertThatRuntimeException().isThrownBy(() -> InputVerifier.verifyNumberIsPos(num));
    }
}