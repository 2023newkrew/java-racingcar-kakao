package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.utils.Validate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationTest {
    @Test
    public void 자동차_이름은_5자_이하만_허용한다() {
        boolean flag = Validate.validateCarNames("aaaaa,bbb,ccc,dd");
        assertTrue(flag);
    }

    @Test
    public void 자동차_이름이_5자를_초과할_경우_예외처리한다() {
        boolean flag = Validate.validateCarNames("aaaaa,bbb,ccc,dd12345");
        assertFalse(flag);
    }

    @Test
    public void 자동차_이름이_빈문자열일_경우_예외처리한다() {
        boolean flag = Validate.validateCarNames("aaaaa,,ccc,dd");
        assertFalse(flag);
    }

    @Test
    public void 게임_라운드_횟수가_1이상의_숫자로_입력된다() {
        assertTrue(Validate.validateRoundNumber("123"));
    }

    @Test
    public void 게임_라운드_횟수가_1미만의_숫자로_입력된다() {
        assertFalse(Validate.validateRoundNumber("-123"));
    }

    @Test
    public void 게임_라운드_횟수가_숫자가_아니도록_입력된다() {
        assertFalse(Validate.validateRoundNumber("abcd"));
    }

}