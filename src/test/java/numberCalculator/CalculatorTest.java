package numberCalculator;

import numberCalculator.exceptions.InvalidFormatException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static numberCalculator.SeparatorParser.DEFAULT_STRING_SEPARATOR;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        this.calculator = new Calculator();
    }

    @Test
    public void stringSplitComma(){
        String origin_str = "0,1,2";
        List<Integer> splitted_numberes = calculator.splitNumbers(origin_str, DEFAULT_STRING_SEPARATOR);
        Assertions.assertThat(splitted_numberes).isEqualTo(Arrays.asList(0, 1, 2));
    }

    @Test
    public void stringSplitColon(){
        String origin_str = "0:1:2";
        List<Integer> splitted_numberes = calculator.splitNumbers(origin_str, DEFAULT_STRING_SEPARATOR);
        Assertions.assertThat(splitted_numberes).isEqualTo(Arrays.asList(0, 1, 2));
    }

    @Test
    public void stringSplitClonAndComma(){
        String origin_str = "0,1:2";
        List<Integer> splitted_numberes = calculator.splitNumbers(origin_str, DEFAULT_STRING_SEPARATOR);
        Assertions.assertThat(splitted_numberes).isEqualTo(Arrays.asList(0, 1, 2));
    }

    @Test
    public void stringEmptyString() {
        String origin_str = "";
        List<Integer> splitted_numberes = calculator.splitNumbers(origin_str, DEFAULT_STRING_SEPARATOR);
        Assertions.assertThat(splitted_numberes).isEqualTo(Collections.emptyList());
    }

    @Test
    public void sumList(){
        Integer result = calculator.summarizeNumbers("0,1,2", DEFAULT_STRING_SEPARATOR);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitNonStringFormat() {
        assertThrows(InvalidFormatException.class, (() -> {
            String originStr = "1,1,e";
            List<Integer> splitted_numberes = calculator.splitNumbers(originStr, DEFAULT_STRING_SEPARATOR);
        }));
    }

    @Test
    public void negativeNumberFormat(){
        assertThrows(InvalidFormatException.class, (() -> {
            String originStr = "1,1,-2";
            List<Integer> splitted_numberes = calculator.splitNumbers(originStr, DEFAULT_STRING_SEPARATOR);
        }));
    }

    @Test
    public void nonExistSeparator() {
        assertThrows(InvalidFormatException.class, () -> {
            String originStr = "1!23";
            calculator.summarizeNumbers(originStr);
        });
    }

    @Test
    public void splitWithCustomSeparator() {
        Integer summary = calculator.summarizeNumbers("//.\n1.2.3");
        Assertions.assertThat(summary).isEqualTo(6);
    }
}
