package racingcar.racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"aasd", "asssz", "zzz"})
    void validName(String name) {
        assertThat(Validator.isValidSingleName(name)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdasdasd", "azx1@!$", "afxvcx@3", "", " ", "ass "})
    void invalidName(String name) {
        assertThat(Validator.isValidSingleName(name)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "z"})
    void invalidTurn(String turn) {
        assertThat(Validator.isValidTurn(turn)).isFalse();
    }

    @Test
    void duplicateNames() {
        assertThat(Validator.isValidNames(Arrays.asList("aaa", "aaa"))).isFalse();
    }

    @Test
    void uniqueValidNames() {
        assertThat(Validator.isValidNames(Arrays.asList("aaa", "aab"))).isTrue();
    }

    @Test
    void validTurn() {
        assertThat(Validator.isValidTurn("12")).isTrue();
    }
}
