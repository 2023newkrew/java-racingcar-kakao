package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AdderTest {
    @Test
    void addNormalTest() {
        String input = "1:2:3";
        NumberParser numberParser = new NumberParser(input);
        numberParser.inputToStringArray();
        int[] intArr = numberParser.stringArrayToIntArray();
        int result = Adder.run(intArr);
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void addCustomTest() {
        String input = "//;\n4;6;9";
        NumberParser numberParser = new NumberParser(input);
        numberParser.inputToStringArray();
        int[] intArr = numberParser.stringArrayToIntArray();
        int result = Adder.run(intArr);
        Assertions.assertThat(result).isEqualTo(19);
    }

    @Test
    void addWrongTest() {
        String input = "//;\n4;w;9";
        NumberParser numberParser = new NumberParser(input);
        numberParser.inputToStringArray();
        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> {
                    numberParser.stringArrayToIntArray();
                });
    }

    @Test
    void addNegativeTest() {
        String input = "//;\n4;-10;9";
        NumberParser numberParser = new NumberParser(input);
        numberParser.inputToStringArray();
        Assertions.assertThatExceptionOfType(NegativeValueException.class)
                .isThrownBy(() -> {
                    numberParser.stringArrayToIntArray();
                });
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    void emptyTest(String input) {
        NumberParser numberParser = new NumberParser(input);
        numberParser.inputToStringArray();
        int[] intArr = numberParser.stringArrayToIntArray();
        int result = Adder.run(intArr);
        Assertions.assertThat(result).isEqualTo(0);
    }
}
