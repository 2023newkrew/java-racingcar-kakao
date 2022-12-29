package calculator.domain;

import static calculator.constant.MessageConstant.INVALID_INPUT_NUMBER_EXCEPTION;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class CommandTest {

    @Test
    void 쌍점과_쉼표가_기본구분자로_등록되어_있다() {
        assertDoesNotThrow(() -> new Command("1,3:4", new ArrayList<>()));
    }


    @ParameterizedTest
    @ValueSource(strings = {"1,2;3", "1,2,3??"})
    void 등록되지_않은_구분자가_입력에_포함되어_있으면_예외가_발생한다(String inputStringNumbers) {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Command(inputStringNumbers)
        );
        assertEquals(INVALID_INPUT_NUMBER_EXCEPTION, exception.getMessage());
    }

}