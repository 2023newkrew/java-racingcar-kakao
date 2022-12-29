package string_addition_calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

// "1" -> 1
// "12" -> 12
// "-1" -> -1

public class StringConverterTest {
    @Test
    void convert_single_digit() {
        assertThat(StringConverter.convertString("1")).isEqualTo(1);
    }

    @Test
    void convert_multiple_digits() {
        assertThat(StringConverter.convertString("12")).isEqualTo(12);
    }

    @Test
    void convert_negative() {
        assertThat(StringConverter.convertString("-1")).isEqualTo(-1);
    }

    @Test
    void convert_not_integer() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringConverter.convertString("hello")).withMessage("정수로 변환할 수 없는 문자열입니다.");
    }
}
