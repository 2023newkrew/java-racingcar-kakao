package car_racing;

import car_racing.domain.InputVerifier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputVerifierTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void verifyNameTest_validInput(String name) {
        //given
        //when
        //then
        Assertions.assertThatNoException().isThrownBy(() -> InputVerifier.verifyName(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "abcdefg", "abcdefgh"})
    void verifyNameTest_invalidInput(String name) {
        //given
        //when
        //then
        Assertions.assertThatRuntimeException().isThrownBy(() -> InputVerifier.verifyName(name));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void verifyNumberIsPos_validInput(int num) {
        //given
        //when
        //then
        Assertions.assertThatNoException().isThrownBy(() -> InputVerifier.verifyNumberIsPos(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void verifyNumberIsPos_invalidInput(int num) {
        //given
        //when
        //then
        Assertions.assertThatRuntimeException().isThrownBy(() -> InputVerifier.verifyNumberIsPos(num));
    }
}