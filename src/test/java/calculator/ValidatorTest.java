package calculator;

import calculator.model.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class ValidatorTest {

    @Test
    @DisplayName("허용되지 않은 특수문자 감지")
    void detectNegative() {
        String[] testStrings = new String[]{"#", "2", "3", "4", "5"};
        assertThrowsExactly(RuntimeException.class, () -> Validator.validate(testStrings));
    }

    @Test
    @DisplayName("음수 감지")
    void detectNonNumber() {
        String[] testStrings = new String[]{"-1", "2", "3", "4", "0"};
        assertThrowsExactly(RuntimeException.class, () -> Validator.validate(testStrings));
    }
}
