package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AdderTest {
    NumberParser numberParser;

    @BeforeEach
    void initialize(){
        numberParser = new NumberParser();
    }
    @Test
    void addNormalTest() {
        String input = "1:2:3";
        int[] intArr = numberParser.inputToIntArray(input);
        int result = Adder.run(intArr);
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void addCustomTest() {
        String input = "//;\n4;6;9";
        int[] intArr = numberParser.inputToIntArray(input);
        int result = Adder.run(intArr);
        Assertions.assertThat(result).isEqualTo(19);
    }

    @Test
    void addWrongTest() {
        String input = "//;\n4;w;9";
        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> {
                    numberParser.inputToIntArray(input);
                });
    }

    @Test
    void addNegativeTest() {
        String input = "//;\n4;-10;9";
        Assertions.assertThatExceptionOfType(NegativeValueException.class)
                .isThrownBy(() -> {
                    numberParser.inputToIntArray(input);
                });
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    void emptyTest(String input) {
        int[] intArr = numberParser.inputToIntArray(input);
        int result = Adder.run(intArr);
        Assertions.assertThat(result).isEqualTo(0);
    }
}
