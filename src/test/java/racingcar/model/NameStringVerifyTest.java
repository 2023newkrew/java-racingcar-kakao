package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameStringVerifyTest {
    @DisplayName("Throw exception when name string is blank")
    @NullAndEmptySource
    @ParameterizedTest
    void blankNameStringTest(final String nameStr) {
        assertThatThrownBy(() -> NameStringVerify.verifyNameString(nameStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Throw exception when name string contains blank car name")
    @ValueSource(strings = {",", "test,", ",test", "test,,", ",test,", ",,test", "test1,test2,", "test1,,test2", ",test1,test2"})
    @ParameterizedTest
    void containBlankCarNameTest(final String nameStr) {
        assertThatThrownBy(() -> NameStringVerify.verifyNameString(nameStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
