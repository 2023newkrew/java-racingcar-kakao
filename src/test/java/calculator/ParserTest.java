package calculator;

import calculator.model.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ParserTest {

    @Test
    @DisplayName("기본 구분자")
    void validDefaultDelimiters() {
        String testString = "1,2:3";
        Parser calc = new Parser(testString);
        String[] result = calc.parse();
        assertArrayEquals(result, new String[]{"1", "2", "3"});
    }

    @Test
    @DisplayName("커스텀 구분자 분리")
    void separateCustomDelimiter() {
        String testString = "//;\n1;2;3,4:5";
        Parser calc = new Parser(testString);
        String[] result = calc.parse();
        assertArrayEquals(result, new String[]{"1", "2", "3", "4", "5"});
    }

    @Test
    @DisplayName("들어오는 문자열이 빈 문자열일 경우")
    void validEmptyValue() {
        String testString = "";
        Parser calc = new Parser(testString);
        String[] result = calc.parse();
        assertArrayEquals(result, new String[]{"0"});
    }

    @Test
    @DisplayName("들어오는 문자열이 null일 경우")
    void validNullValue() {
        String testString = null;
        Parser calc = new Parser(testString);
        String[] result = calc.parse();
        assertArrayEquals(result, new String[]{"0"});
    }
}
