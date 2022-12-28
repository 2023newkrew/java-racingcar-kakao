package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class RacingTest {
    @Test
    public void 자동차_이름이_정상적으로_입력된다() {
        Racing racing = new Racing();
        assertTrue(racing.registerCarNames("pobi,crong,honux"));
    }

    @Test
    public void 자동차_중_이름이_5자가_초과된_자동차가_입력된다() {
        Racing racing = new Racing();
        assertFalse(racing.registerCarNames("pobi,crong,honux12312"));
    }

    @Test
    public void 게임_라운드_횟수가_1이상의_숫자로_입력된다() {
        Racing racing = new Racing();
        assertTrue(racing.registerCarRoundNum("123"));
    }

    @Test
    public void 게임_라운드_횟수가_1미만의_숫자로_입력된다() {
        Racing racing = new Racing();
        assertFalse(racing.registerCarRoundNum("-123"));
    }

    @Test
    public void 게임_라운드_횟수가_숫자가_아니도록_입력된다() {
        Racing racing = new Racing();
        assertFalse(racing.registerCarRoundNum("abcd"));
    }

    @Test
    public void 게임이_잘_종료되었다() {
        Racing racing = new Racing();
        racing.registerCarNames("a,b,c");
        racing.registerCarRoundNum("5");
        assertTrue(racing.round());
    }

    @Test
    public void 랜덤값이_4_이상일_경우_자동차가_전진한다() {
        Racing racing = new Racing() {
            @Override
            protected boolean random() {
                return true;
            }
        };
        racing.registerCarNames("a, b");
        racing.registerCarRoundNum("1");
        racing.round();
        assertThat(racing.getCar(1).getPosition()).isEqualTo(1);
    }

    @Test
    public void 랜덤값이_3_이하일_경우_자동차가_정지한다() {
        Racing racing = new Racing() {
            @Override
            protected boolean random() {
                return false;
            }
        };
        racing.registerCarNames("a");
        racing.registerCarRoundNum("1");
        racing.round();
        assertThat(racing.getCar(0).getPosition()).isEqualTo(0);
    }
}
