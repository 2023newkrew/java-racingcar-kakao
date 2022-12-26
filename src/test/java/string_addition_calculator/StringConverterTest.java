package string_addition_calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

// "1" -> 1
// "12" -> 12
// "-1" -> -1

public class StringConverterTest {
    StringConverter converter;

    @BeforeEach
    void setUp() {
        converter = new StringConverter();
    }

    @Test
    void convert_single_digit() {
        converter.convertString("1");
        assertThat(converter.getResult()).isEqualTo(1);
    }

    @Test
    void convert_multiple_digits() {
        converter.convertString("12");
        assertThat(converter.getResult()).isEqualTo(12);
    }

    @Test
    void convert_negative() {
        converter.convertString("-1");
        assertThat(converter.getResult()).isEqualTo(-1);
    }

    @Test
    void convert_not_integer() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> converter.convertString("hello")).withMessage("정수로 변환할 수 없는 문자열입니다.");
    }
}
