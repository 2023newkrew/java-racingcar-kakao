package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RacingTest {
    @Test
    public void registerCarNamesTest(){
        Racing racing = new Racing();
        assertTrue(racing.registerCarNames("pobi,crong,honux"));
    }
    @Test
    public void registerCarNamesTest2(){
        Racing racing = new Racing();
        assertFalse(racing.registerCarNames("pobi,crong,honux12312"));
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
    public void RoundTest(){
        Racing racing = new Racing();
        racing.registerCarNames("a,b,c");
        racing.registerCarRoundNum("5");
        assertTrue(racing.round());
    }
}
