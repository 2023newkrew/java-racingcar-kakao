package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingTest {

    @Nested
    @DisplayName("자동차 이름 등록 테스트")
    class registerCarNamesTest {
        @Test
        @DisplayName("성공")
        public void success() {
            Racing racing = new Racing();
            assertTrue(racing.registerCarNames("pobi,crong,honux"));
        }

        @Test
        @DisplayName("5자 초과 이름 등록 실패")
        public void fail() {
            Racing racing = new Racing();
            assertFalse(racing.registerCarNames("pobi,crong,honux12312"));
        }
    }

    @Test
    public void registerCarRoundNumTest() {
        Racing racing = new Racing();
        assertTrue(racing.registerCarRoundNum("123"));
    }

    @Test
    public void registerCarRoundNumTest2() {
        Racing racing = new Racing();
        assertFalse(racing.registerCarRoundNum("abcd"));
    }

    @Test
    public void RoundTest() {
        Racing racing = new Racing();
        racing.registerCarNames("a,b,c");
        racing.registerCarRoundNum("5");
        assertTrue(racing.round());
    }
}
