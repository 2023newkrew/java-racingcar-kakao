package str_calc.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class StringCalculatorTest {
    @Test
    @DisplayName("can return sum from text")
    public void sumText() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.sum("1,2:3"));
        assertThrows(RuntimeException.class, () -> stringCalculator.sum("1,2:-3"));
    }
}
