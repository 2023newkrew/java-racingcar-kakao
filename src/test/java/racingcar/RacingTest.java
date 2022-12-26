package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingTest {

    @ParameterizedTest
    @CsvSource(value = {"Pobi;true",
                        "Ppoobbii;false"}, delimiter = ';')
    void verifyNameTest(String input, String expected){
        Race race = new Race();
        String result = "false";
        if (race.verifyName(input)){
            result = "true";
        }
        assertEquals(result, expected);
    }

    @Test
    void nameSplitTest() {
        Race race = new Race("pobi,crong,honux");
        assertArrayEquals(race.nameSplit(), new String[] {"pobi", "crong", "honux"});
    }
}
