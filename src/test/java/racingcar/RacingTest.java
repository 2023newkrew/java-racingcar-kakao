package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingTest {
    @Test
    public void registerCarNamesTest(){
        Racing racing = new Racing();
        assertEquals(racing.RegisterCarNames("pobi,crong,honux"), true);
    }
    @Test
    public void registerCarNamesTest2(){
        Racing racing = new Racing();
        assertEquals(racing.RegisterCarNames("pobi,crong,honux12312"), false);
    }
    @Test
    public void registerCarRoundNumTest() {
        Racing racing = new Racing();
        assertEquals(racing.RegisterCarRoundNum("123"), true);
    }
    @Test
    public void registerCarRoundNumTest2() {
        Racing racing = new Racing();
        assertEquals(racing.RegisterCarRoundNum("abcd"), false);
    }
}
