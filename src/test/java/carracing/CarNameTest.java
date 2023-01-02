package carracing;

import carracing.domain.CarName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    @DisplayName("길이 0 보다 크고 5이하인 이름으로 CarName 생성 가능")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void carNameTest_validInput(String name) {
        //given
        //when
        //then
        Assertions.assertThatNoException().isThrownBy(() -> new CarName(name));
    }

    @DisplayName("길이 5보다 큰 이름 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "abcdefg", "abcdefgh"})
    void carNameTest_invalidInput(String name) {
        //given
        //when
        //then
        Assertions.assertThatRuntimeException().isThrownBy(() -> new CarName(name));
    }

    @DisplayName("빈 문자열, null 이름 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void carNameTest_NullAndEmptyInput(String name) {
        //given
        //when
        //then
        Assertions.assertThatRuntimeException().isThrownBy(() -> new CarName(name));
    }
}