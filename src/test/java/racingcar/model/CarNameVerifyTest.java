package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarNameVerifyTest {
    @DisplayName("Throw exception when car name is blank")
    @NullAndEmptySource
    @ParameterizedTest
    void blackCarNameTest(final String name) {
        assertThatThrownBy(() -> CarNameVerify.verifyCarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
