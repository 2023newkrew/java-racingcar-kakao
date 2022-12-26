package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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

}
