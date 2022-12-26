package string_add_calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {
    @Test
    public void list_sum() {
        Calculator calculator = new Calculator(new String[] {"1", "2", "3"});
        assertEquals(calculator.cal(), 6);
    }
}
