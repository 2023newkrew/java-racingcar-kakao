package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.utils.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilsTest {

    @DisplayName("숫자 이외의 값 변환 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = { "_", "%^", ",./" })
    void throwExceptionIfValueIsNotNumeric(String value) {
        assertThatThrownBy(() -> StringUtils.convertToInt(value))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자 값이 들어올 경우 정상적으로 변환된다.")
    @ParameterizedTest
    @CsvSource(value = { "'35', 35, '1', 1, '-63', -63" })
    void convertToIntIfValueIsNumeric(String value, int convertedValue) {
        assertThat(StringUtils.convertToInt(value)).isEqualTo(convertedValue);
    }

}