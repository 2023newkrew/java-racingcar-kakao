package addcal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void CalculatorInputTest() {
        Calculator cal = new Calculator();
        String input = "//a\n1a2a3a4a5";
        cal.Run(input);
        int result = cal.addCal.resultNum.getNum();
        assertEquals(result, 15);
    }

    @Test
    void RunTest() {
        Calculator cal = new Calculator();
        String input = "1,2,3";
        assertEquals(cal.Run(input), true);
    }

}
