package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import calculator.model.Calculator;
import calculator.model.Parser;
import calculator.model.Validator;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("문자 배열 숫자 변환 후 덧셈")
    void convertToNumbers() {
        String[] testStrings = new String[]{"1", "2", "3", "4", "5"};
        Calculator calc = new Calculator();
        assertEquals(calc.sumAll(testStrings), 15);
    }

    @Test
    @DisplayName("최종 덧셈 결과")
    void calculateResult() {
        String testString = "//;\n1;2;3,4:5";
        Parser parser = new Parser(testString);
        String[] parseResult = parser.parse();

        Calculator calc = new Calculator();
        int result = calc.sumAll(parseResult);

        assertEquals(result, 15);
    }
}
