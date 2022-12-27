package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;

public class NumberParserTest {

    private static final List<String> defaultDelimiters = Arrays.asList(",", ":");
    @Test
    void inputToStringArray() {
        NumberParser numberParser = new NumberParser("1:2:3", defaultDelimiters);
        Assertions.assertThat(numberParser.inputToStringArray()).containsExactly("1","2","3");
    }
    @Test
    void customInputToStringArray() {
        NumberParser numberParser = new NumberParser("//s\n1s2s3", defaultDelimiters);
        Assertions.assertThat(numberParser.inputToStringArray()).containsExactly("1","2","3");
    }

    @Test
    void stringArrayToIntArray() {
        NumberParser numberParser = new NumberParser("1:2:3", defaultDelimiters);
        numberParser.inputToStringArray();
        Assertions.assertThat(numberParser.stringArrayToIntArray()).containsExactly(1,2,3);
    }
    @Test
    void stringArrayToIntArrayException() {
        NumberParser numberParser = new NumberParser("a:2:3", defaultDelimiters);
        numberParser.inputToStringArray();

        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> {
                    numberParser.stringArrayToIntArray();
                });
    }

    @Test
    void negativeValueException(){
        NumberParser numberParser = new NumberParser("-1:2:3", defaultDelimiters);
        numberParser.inputToStringArray();

        assertThatExceptionOfType(NegativeValueException.class)
                .isThrownBy(() -> {
                    numberParser.stringArrayToIntArray();
                });

    }
}
