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
    void convertEmptyToZero() {
        String[] arr = {"1","","2"};
        StringSplitter stringSplitter = new StringSplitter("");
        assertArrayEquals(new String[] {"1","0","2"}, stringSplitter.convertEmptyToZero(arr));
    }

    @Test
    void split() {
        String str = "//;;\n6;;0;;34;;45";
        String str2 = "6,,34;45";
        String str3 = "5";

        StringSplitter stringSplitter = new StringSplitter(str);
        StringSplitter stringSplitter2 = new StringSplitter(str2);
        StringSplitter stringSplitter3 = new StringSplitter(str3);

        String[] expectedResult = {"6", "0", "34", "45"};

        assertArrayEquals(expectedResult, stringSplitter.split());
        assertArrayEquals(expectedResult, stringSplitter2.split());
        assertArrayEquals(new String[]{"5"}, stringSplitter3.split());
    }

    @Test
    void split_empty() {
        String str1 = "";
        String str2 = null;
        String[] result = {"0"};

        StringSplitter stringSplitter1 = new StringSplitter(str1);
        StringSplitter stringSplitter2 = new StringSplitter(str2);

        assertArrayEquals(result, stringSplitter1.split());
        assertArrayEquals(result, stringSplitter2.split());
    }
}