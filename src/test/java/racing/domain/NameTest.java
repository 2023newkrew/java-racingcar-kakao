package racing.domain;

import static org.junit.jupiter.api.Assertions.*;
import static racing.constant.MessageConstant.INVALID_BLANK_NAME_EXCEPTION;
import static racing.constant.MessageConstant.INVALID_NAME_LENGTH_EXCEPTION;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

class NameTest {

    @ParameterizedTest
    @NullSource
    @EmptySource
    void 이름은_null_또는_공백이_들어갈_수_없다(String nameString) {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> new Name(nameString));
        assertEquals(INVALID_BLANK_NAME_EXCEPTION, exception.getMessage());
    }

    @Test
    void 이름의_길이는_5글자를_넘어갈_수_없다() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> new Name("marcus"));
        assertEquals(INVALID_NAME_LENGTH_EXCEPTION, exception.getMessage());
    }

}