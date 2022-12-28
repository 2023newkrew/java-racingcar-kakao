package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionTest {
    @Test
    void exceptionTest() {
        Calculator calculator = new Calculator(new String[] {"-1", "2", "3"});
        String str;
        try {
            calculator.isInteger();
            str = "성공";
        } catch (RuntimeException e) {
            str = "실패";
        }

        assertEquals(str, "실패");
    }
}
