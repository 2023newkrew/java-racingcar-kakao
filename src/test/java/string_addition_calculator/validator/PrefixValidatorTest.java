package string_addition_calculator.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

// "1:2,3" -> valid
// "//;\n1,2,3" -> valid
// "//;;\n1,2,3" -> invalid
// "hello" -> invalid
public class PrefixValidatorTest {
    PrefixValidator validator;
    @BeforeEach
    void setUp() {
        validator = new PrefixValidator();
    }

    @Test
    void invalid_prefix_test1() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->  validator.validate("//;;\n1,2,3"))
                .withMessage("양식에 알맞게 입력해주세요.");
    }

    @Test
    void invalid_prefix_test2() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->  validator.validate("hello"))
                .withMessage("양식에 알맞게 입력해주세요.");
    }

    @Test
    void digit_prefix_test() {
        assertDoesNotThrow(() -> validator.validate("1:2,3"));
    }

    @Test
    void custom_separator_prefix_test() {
        assertDoesNotThrow(() -> validator.validate("//;\n1,2,3"));
    }
}
