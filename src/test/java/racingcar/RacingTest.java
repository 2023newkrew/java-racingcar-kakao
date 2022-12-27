package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RacingTest {
    @Test
    public void registerCarNamesTest(){
        Racing racing = new Racing();
        assertTrue(racing.RegisterCarNames("pobi,crong,honux"));
    }
    @Test
    public void registerCarNamesTest2(){
        Racing racing = new Racing();
        assertFalse(racing.RegisterCarNames("pobi,crong,honux12312"));
    }
    @Test
    public void registerCarRoundNumTest() {
        Racing racing = new Racing();
        assertTrue(racing.RegisterCarRoundNum("123"));
    }
    @Test
    public void registerCarRoundNumTest2() {
        Racing racing = new Racing();
        assertFalse(racing.RegisterCarRoundNum("abcd"));
    }
/*
    @Test
    public void RunTest(){
        Racing racing = new Racing();
        racing.RegisterCarRoundNum("5");
        assertEquals(racing.Run(), 5);

    }
*/
    @Test
    public void RoundTest(){
        Racing racing = new Racing();
        racing.RegisterCarNames("a,b,c");
        racing.RegisterCarRoundNum("5");
        assertTrue(racing.Round());
    }
}
