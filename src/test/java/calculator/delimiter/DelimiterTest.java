package calculator.delimiter;

import calculator.constant.MessageConstant;
import calculator.domain.calculator.delimiter.Delimiter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.constant.MessageConstant.*;
import static org.assertj.core.api.Assertions.*;

public class DelimiterTest {

    @ParameterizedTest
    @DisplayName("구분자의 길이는 1이여야 합니다.")
    @ValueSource(strings = {"earth", "jupiter", "mars", "go"})
    public void invalidDelimiterLength(String input) {
        assertThatThrownBy(() -> new Delimiter(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching(DELIMITER_LENGTH_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("구분자는 숫자 형태일 수 없습니다.")
    @ValueSource(strings = {"1", "5", "8", "0"})
    public void invalidFormatDelimiter(String input) {
        assertThatThrownBy(() -> new Delimiter(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching(DELIMITER_FORMAT_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("문자로 이루어진 1글자의 구분자는 생성 가능합니다.")
    @ValueSource(strings = {"!", ";", "?", "w", "아"})
    public void validDelimiter(String input) {
        assertThatCode(() -> new Delimiter(input))
                .doesNotThrowAnyException();
    }
}
