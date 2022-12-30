package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "z"})
    void invalidTurn(String turn) {
        assertThat(Validator.isValidTurn(turn)).isFalse();
    }

    @Test
    void validTurn() {
        assertThat(Validator.isValidTurn("12")).isTrue();
    }
}
