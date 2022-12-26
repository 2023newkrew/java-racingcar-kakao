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
        Race race = new Race();
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
        race.carInput(race.nameSplit());
        race.printRace();
        String actual = out.toString();
        assertEquals(actual,"pobi : \n" +
                "crong : \n" +
                "honux : \n");
    }

    @Test
    void raceMaxCntTest() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Race race = new Race("pobi,crong,honux");
        race.carInput(race.nameSplit());
        race.getCars().get(0).move();
        race.getCars().get(0).move();
        race.getCars().get(0).move();
        assertEquals(race.raceMaxCnt(), 3);
    }
}
