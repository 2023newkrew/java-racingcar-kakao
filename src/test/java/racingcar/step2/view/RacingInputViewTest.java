package racingcar.step2.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingInputViewTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux;pobi,crong,honux"}, delimiter = ';')
    void 자동차_이름들을_입력_받는_기능(String input, String expect){
        systemIn(input);
        assertTrue(() -> new RacingInputView().getCarNames().equals(expect));
    }

    @Test
    void 턴_횟수가_숫자가_아니면_예외_처리(){
        assertThatThrownBy(() -> new RacingInputView().isNumeric("a")).
                isInstanceOf(RuntimeException.class);
    }

    @Test
    void 턴_횟수가_음수이면_예외_처리(){
        assertThatThrownBy(() -> new RacingInputView().isNumeric("-1")).
                isInstanceOf(RuntimeException.class);
    }

    @Test
    void 턴_횟수가_양의_정수면_숫자로_변환(){
        assertEquals(new RacingInputView().isNumeric("5"), 5);
    }
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

}