package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameStringVerifyTest {
    @DisplayName("Throw exception when name string is blank")
    @NullAndEmptySource
    @ParameterizedTest
    void blankNameStringTest(final String nameStr) {
        assertThatThrownBy(() -> NameStringVerify.verifyNameString(nameStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
