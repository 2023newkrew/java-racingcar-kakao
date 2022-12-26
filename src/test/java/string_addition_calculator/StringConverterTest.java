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
        StringConverter converter = new StringConverter();
        converter.convertString("1");
        assertThat(converter.getResult()).isEqualTo(1);
    }

    @Test
    void convert_multiple_digits() {
        StringConverter converter = new StringConverter();
        converter.convertString("12");
        assertThat(converter.getResult()).isEqualTo(12);
    }

    @Test
    void convert_negative() {
        StringConverter converter = new StringConverter();
        converter.convertString("-1");
        assertThat(converter.getResult()).isEqualTo(-1);
    }

    @Test
    void convert_not_integer() {
        StringConverter converter = new StringConverter();
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> converter.convertString("hello")).withMessage("정수로 변환할 수 없는 문자열입니다.");
    }
}
