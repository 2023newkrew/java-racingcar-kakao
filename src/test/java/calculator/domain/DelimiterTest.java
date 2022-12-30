package calculator.domain;

import static calculator.constant.MessageConstant.DELIMITER_FORMAT_EXCEPTION;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    @ParameterizedTest
    @ValueSource(chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'})
    void 구분자로_숫자는_들어올_수_없습니다(char delimiter) {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> new Delimiter(delimiter)
                );
        assertEquals(DELIMITER_FORMAT_EXCEPTION, exception.getMessage());
    }

}