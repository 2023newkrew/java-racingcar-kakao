package string_addition_calculator.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

// input :

public class NonNegativeValidatorTest {

    NonNegativeValidator nonNegativeValidator;

    @BeforeEach
    void setUp() {
        nonNegativeValidator = new NonNegativeValidator();
    }

    @Test
    void negative_integer_throws_exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->  nonNegativeValidator.validate(-1))
                .withMessage("0 이상의 정수만 허용합니다.");
    }

    @Test
    void zero_does_not_throw_exception() {
        assertDoesNotThrow(() -> nonNegativeValidator.validate(0));
    }

    @Test
    void positive_does_not_throw_exception() {
        assertDoesNotThrow(() -> nonNegativeValidator.validate(1));
    }
}
