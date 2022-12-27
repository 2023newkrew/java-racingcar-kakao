package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"aasd", "asssz", "zzz"})
    void validName(String name) {
        assertThat(Validator.validateName(name)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdasdasd", "azx1@!$", "afxvcx@3", "", " ", "ass "})
    void invalidName(String name) {
        assertThat(Validator.validateName(name)).isFalse();
    }
}
