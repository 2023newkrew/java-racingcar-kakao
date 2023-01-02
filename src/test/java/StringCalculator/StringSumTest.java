package StringCalculator;

import StringCalculator.StringSum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringSumTest {

    private StringSum stringSum;

    @BeforeEach
    void setUp() {
        stringSum = new StringSum("1:2,3");
    }

    @Test
    public void customDelimiterTest() {
        StringSum customStringSum = new StringSum("//;\n1;2;3");
        String customDelimiter = customStringSum.customDelimiter();
        assertThat(customDelimiter).isEqualTo(";");
    }

    @Test
    public void splitTest() {
        String[] testList = new String[]{"1", "2", "3"};
        String[] list = stringSum.splitByDelimiter();
        assertThat(list).isEqualTo(testList);
    }

    @Test
    public void stringToIntegerTest() {
        Integer testInteger = stringSum.stringToInteger("1");
        assertThat(testInteger).isEqualTo(1);
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            stringSum.stringToInteger("abc");
        });
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            stringSum.stringToInteger("-1");
        });
    }

    @Test
    public void summationTest() {
        int[] numbers = new int[]{1, 2, 3};
        assertThat(stringSum.summation(numbers)).isEqualTo(6);
    }
}
