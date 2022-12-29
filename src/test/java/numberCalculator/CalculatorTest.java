package numberCalculator;

import numberCalculator.exceptions.NegativeArgumentException;
import numberCalculator.exceptions.NonIntegerArgumentException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        this.calculator = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2", "0:1:2", "0,1:2"})
    public void stringSplitWithDefaultSeparators(String originStr){
        List<Integer> splitNumbers = calculator.splitNumbers(originStr, SeparatorParser.DEFAULT_SEPARATORS);
        Assertions.assertThat(splitNumbers).isEqualTo(Arrays.asList(0, 1, 2));
    }

    @Test
    public void splitEmptyString() {
        String originStr = "";
        List<Integer> splitNumbers = calculator.splitNumbers(originStr, SeparatorParser.DEFAULT_SEPARATORS);
        Assertions.assertThat(splitNumbers).isEqualTo(Collections.emptyList());
    }

    @Test
    public void sumList(){
        Integer result = calculator.summarizeNumbers("0,1,2", SeparatorParser.DEFAULT_SEPARATORS);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitNonStringFormat() {
        assertThrows(NonIntegerArgumentException.class, (() -> {
            String originStr = "1,1,e";
            List<Integer> splitNumbers = calculator.splitNumbers(originStr, SeparatorParser.DEFAULT_SEPARATORS);
        }));
    }

    @Test
    public void negativeNumberFormat(){
        assertThrows(NegativeArgumentException.class, (() -> {
            String originStr = "1,1,-2";
            List<Integer> splitNumbers = calculator.splitNumbers(originStr, SeparatorParser.DEFAULT_SEPARATORS);
        }));
    }

    @Test
    public void nonExistSeparator() {
        assertThrows(NonIntegerArgumentException.class, () -> {
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
