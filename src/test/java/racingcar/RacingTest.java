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

    @Nested
    @DisplayName("총 라운드 수 등록 테스트")
    class registerCarRoundNumTest {
        @Test
        @DisplayName("양수")
        public void positiveNumber() {
            Racing racing = new Racing();
            assertTrue(racing.registerCarRoundNum("123"));
        }

        @Test
        @DisplayName("음수")
        public void negativeNumber() {
            Racing racing = new Racing();
            assertFalse(racing.registerCarRoundNum("-12"));
        }

        @Test
        @DisplayName("음수")
        public void zero() {
            Racing racing = new Racing();
            assertFalse(racing.registerCarRoundNum("0"));
        }

        @Test
        @DisplayName("문자열")
        public void strings() {
            Racing racing = new Racing();
            assertFalse(racing.registerCarRoundNum("abcd"));
        }

        @Test
        @DisplayName("혼합 테스트")
        public void mix() {
            Racing racing = new Racing();
            assertFalse(racing.registerCarRoundNum("ab23c"));
        }
    }


    @Test
    public void RoundTest() {
        Racing racing = new Racing();
        racing.registerCarNames("a,b,c");
        racing.registerCarRoundNum("5");
        assertTrue(racing.progressRound());
    }
}
