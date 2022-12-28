package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ExceptionTest {
    @Test
    void exceptionTest() {
        Calculator calculator = new Calculator(new String[] {"-1", "2", "3"});

        assertThatThrownBy(() -> calculator.verifyAllNumeric())
                .isInstanceOf(RuntimeException.class);
    }
}