package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    void split() {
        StringCalculator calculator = new StringCalculator();
        String[] result = calculator.split("1,2");
        String[] expected = {"1", "2"};
        assertThat(result).isEqualTo(expected);
    }
}
