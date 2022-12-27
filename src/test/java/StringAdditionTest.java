import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import string_calculator.model.Calculator;
import string_calculator.model.Parser;
import string_calculator.model.Validator;

import static org.junit.jupiter.api.Assertions.*;

public class StringAdditionTest {

    @Test
    @DisplayName("기본 구분자 - 정답")
    void defaultDelimitersValid() {
        String testString = "1,2:3";
        Parser calc = new Parser(testString);
        String[] result = calc.parse();
        assertArrayEquals(result, new String[]{"1", "2", "3"});
    }

    @Test
    @DisplayName("커스텀 구분자 분리 - 정답")
    void separateCustomDelimiter() {
        String testString = "//;\n1;2;3,4:5";
        Parser calc = new Parser(testString);
        String[] result = calc.parse();
        assertArrayEquals(result, new String[]{"1", "2", "3", "4", "5"});
    }

    @Test
    @DisplayName("허용되지 않은 특수문자 감지")
    void detectNegative() {
        String[] testStrings = new String[]{"#", "2", "3", "4", "5"};
        assertThrowsExactly(RuntimeException.class, ()-> Validator.validate(testStrings));
    }

    @Test
    @DisplayName("음수 감지")
    void detectNonNumber() {
        String[] testStrings = new String[]{"-1", "2", "3", "4", "0"};
        assertThrowsExactly(RuntimeException.class, ()->Validator.validate(testStrings));
    }

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
