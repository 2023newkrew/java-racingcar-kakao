package addcal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {
    @Test
    void CalculatorInputTest() {
        Calculator cal = new Calculator();
        String input = "//a\n1a2a3a4a5";
        cal.run(input);
        int result = cal.addCal.resultNum.getNum();
        assertEquals(result, 15);
    }

    @Test
    void RunTest() {
        Calculator cal = new Calculator();
        String input = "1,2,3";
        assertTrue(cal.run(input));
    }

}
