package racingcar.step2.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NameSplitTest {
    @Test
    void 입력받은_자동차_이름들을_쉼표_구분자로_구분(){
        NameSplit nameSplit = new NameSplit();
        assertTrue(Arrays.deepEquals(nameSplit.NameCsvToArray("pobi,crong,honux")
                ,(new String[]{"pobi", "crong", "honux"})));
    }
}
