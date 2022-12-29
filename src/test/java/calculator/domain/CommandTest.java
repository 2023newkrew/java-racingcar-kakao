package calculator.domain;

import static calculator.constant.MessageConstant.INVALID_INPUT_NUMBER_EXCEPTION;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


class CommandTest {

    @Test
    void 분리된_숫자영역은_숫자와_구분자들로만_구성되어_있어야_한다() {

        // when
        List<Character> delimiters = new ArrayList<>(Arrays.asList(':', ','));
        String inputStringNumbers = "1,2,3";

        // given & then
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Command(inputStringNumbers, delimiters)
        );
        assertEquals(INVALID_INPUT_NUMBER_EXCEPTION, exception.getMessage());
    }

}