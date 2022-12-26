package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringSplitterTest {

    @Test
    void hasCustomDelimiter_true() {
        String str = "//;;\n1;;2;;3;;45";
        StringSplitter stringSplitter = new StringSplitter(str);
        assertTrue(stringSplitter.hasCustomDelimiter());
    }

    @Test
    void hasCustomDelimiter_false() {
        String str = "1,2,3,45";
        StringSplitter stringSplitter = new StringSplitter(str);
        assertFalse(stringSplitter.hasCustomDelimiter());
    }

    @Test
    void extractDelimiter() {
        String str = "1,2,3";
        StringSplitter stringSplitter = new StringSplitter(str);
        String delimiter = stringSplitter.extractDelimiter();
        assertThat(delimiter).isEqualTo(",");

        str = "//;;\n1;;2;;3;;45";
        stringSplitter = new StringSplitter(str);
        delimiter = stringSplitter.extractDelimiter();
        assertThat(delimiter).isEqualTo(";;");
    }

    @Test
    void split() {
        String str = "//;;\n6;;7;;34;;45";
        String str2 = "6,7,34,45";

        StringSplitter stringSplitter = new StringSplitter(str);
        StringSplitter stringSplitter2 = new StringSplitter(str2);

        String[] expectedResult = {"6", "7", "34", "45"};

        assertArrayEquals(expectedResult, stringSplitter.split());
        assertArrayEquals(expectedResult, stringSplitter2.split());
    }
}