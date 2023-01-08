package str_calc.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class StringCalculatorTest {
    @Test
    @DisplayName("can return sum from text")
    public void can_return_sum_from_text() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.sum("1,2:3"));
    }

    @Test
    @DisplayName("can add a custom delimiter")
    public void can_add_a_custom_delimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(10, stringCalculator.sum("//;\n1,2:3;4"));
    }

    @Test
    @DisplayName("can convert empty to 0")
    public void can_convert_empty_to_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.sum("1,2:,:3"));
    }

    @Test
    @DisplayName("can validate wrong text")
    public void can_validate_wrong_text() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThrows(RuntimeException.class, () -> stringCalculator.sum("1,2:-3"));
        assertThrows(RuntimeException.class, () -> stringCalculator.sum("1,2:a"));
    }
}
