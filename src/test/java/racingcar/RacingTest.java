package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingTest {

    @ParameterizedTest
    @CsvSource(value = {"Pobi;true",
                        "Ppoobbii;false"}, delimiter = ';')
    void verifyNameTest(String input, String expected){
        Race race = new Race("pobi,crong,honux");
        String result = "false";
        try {
            race.verifyName(input);
            result = "true";
        }catch (Exception e){

        }
        assertEquals(result, expected);
    }

    @Test
    void nameSplitTest() {
        Race race = new Race("pobi,crong,honux");
        assertArrayEquals(race.nameSplit(), new String[] {"pobi", "crong", "honux"});
    }

    @Test
    void carInputTest() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Race race = new Race("pobi,crong,honux");
        race.carNamesCheck(race.nameSplit());
        race.printRace();
        String actual = out.toString();
        assertEquals(actual,"pobi : -\n" +
                "crong : -\n" +
                "honux : -\n\n");
    }

    @Test
    void raceMaxCntTest() {
        Race race = new Race("pobi,crong,honux");
        race.carNamesCheck(race.nameSplit());
        race.getCars().get(0).move();
        race.getCars().get(0).move();
        race.getCars().get(0).move();
        assertEquals(race.raceMaxCnt(), 4);
    }

    @Test
    void raceWinnerTest(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Race race = new Race("pobi,crong,honux");
        race.carNamesCheck(race.nameSplit());
        race.getCars().get(0).move();
        race.getCars().get(0).move();
        race.getCars().get(0).move();

        race.getCars().get(2).move();
        race.getCars().get(2).move();
        race.getCars().get(2).move();

        race.raceWinner();
        String actual = out.toString();
        assertEquals(actual, "pobi, honux가 최종 우승했습니다.\n");
    }
}
