package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;

public class NumberParserTest {
    @Test
    void inputToStringArray() {
        NumberParser numberParser = new NumberParser("1:2:3");
        Assertions.assertThat(numberParser.inputToStringArray()).containsExactly("1","2","3");
    }
    @Test
    void customInputToStringArray() {
        NumberParser numberParser = new NumberParser("//s\n1s2s3");
        Assertions.assertThat(numberParser.inputToStringArray()).containsExactly("1","2","3");
    }

    @Test
    void stringArrayToIntArray() {
        NumberParser numberParser = new NumberParser("1:2:3");
        numberParser.inputToStringArray();
        Assertions.assertThat(numberParser.stringArrayToIntArray()).containsExactly(1,2,3);
    }
    @Test
    void stringArrayToIntArrayException() {
        NumberParser numberParser = new NumberParser("a:2:3");
        numberParser.inputToStringArray();

        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> {
                    numberParser.stringArrayToIntArray();
                });
    }

    @Test
    void negativeValueException(){
        NumberParser numberParser = new NumberParser("-1:2:3");
        numberParser.inputToStringArray();

        assertThatExceptionOfType(NegativeValueException.class)
                .isThrownBy(() -> {
                    numberParser.stringArrayToIntArray();
                });

    }
}
