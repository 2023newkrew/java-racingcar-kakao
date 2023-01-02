package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RaceTest {
    @DisplayName("Max position is the biggest position in the list of cars")
    @Test
    void raceMaxPositionTest() {
        Race race = new Race("pobi,crong,honux", 1);

        race.getCars().get(0).move();
        race.getCars().get(0).move();
        race.getCars().get(0).move();

        assertEquals(race.raceMaxPosition(), 4);
    }

    @DisplayName("Return names of cars that position is same with the max position")
    @Test
    void raceWinnerTest() {
        Race race = new Race("pobi,crong,honux", 1);

        race.getCars().get(0).move();
        race.getCars().get(0).move();
        race.getCars().get(0).move();

        race.getCars().get(2).move();
        race.getCars().get(2).move();
        race.getCars().get(2).move();

        assertEquals(race.raceWinner(), "pobi, honux");
    }

    @DisplayName("Terminate race when 0 turn left")
    @Test
    void isEndTrueTest() {
        assertTrue(new Race("test1,test2,test3", 0).isEnd());
    }

    @DisplayName("Don't terminate race when turn left")
    @Test
    void isEndFalseTest() {
        assertFalse(new Race("test1,test2,test3", 1).isEnd());
    }
}
