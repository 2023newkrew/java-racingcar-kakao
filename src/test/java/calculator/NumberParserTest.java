package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;

public class NumberParserTest {
    NumberParser numberParser;

    @BeforeEach
    void initialize(){
        numberParser = new NumberParser();
    }
    @Test
    void inputToIntArray() {
        Assertions.assertThat(numberParser.inputToIntArray("1:2:3")).containsExactly(1,2,3);
    }
    @Test
    void customInputToIntArray() {
        Assertions.assertThat(numberParser.inputToIntArray("//s\n1s2s3")).containsExactly(1,2,3);
    }

    @Test
    void stringArrayToIntArray() {
        Assertions.assertThat(numberParser.inputToIntArray("1:2:3")).containsExactly(1,2,3);
    }
    @Test
    void ThrowIfNonNumberProvided() {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> {
                    numberParser.inputToIntArray("a:2:3");
                });
    }

    @Test
    void ThrowIfNegativeNumberProvided(){
        assertThatExceptionOfType(NegativeValueException.class)
                .isThrownBy(() -> {
                    numberParser.inputToIntArray("-1:2:3");
                });
    }

    @Test
    void hahaha()
    {
        assertThat("안녕하세요".length()).isEqualTo(5);
    }
}
