package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringSplitterTest {

    @Test
    void 커스텀_구분자가_존재한다() {
        String input = "//;;\n1;;2;;3;;45";
        StringSplitter stringSplitter = new StringSplitter(input);

        assertTrue(stringSplitter.hasCustomDelimiter());
    }

    @ValueSource(strings = {"1,2,3,45"})
    @NullAndEmptySource
    @ParameterizedTest
    void 커스텀_구분자가_존재하지_않는다(String input) {
        StringSplitter stringSplitter = new StringSplitter(input);

        assertFalse(stringSplitter.hasCustomDelimiter());
    }

    @Test
    void 커스텀_구분자를_추출해_반환할_수_있다() {
        String str = "1,2,3";
        StringSplitter stringSplitter = new StringSplitter(str);

        String delimiter = stringSplitter.extractDelimiter();

        assertThat(delimiter).isEqualTo(",|;");

        str = "//;;\n1;;2;;3;;45";
        stringSplitter = new StringSplitter(str);

        delimiter = stringSplitter.extractDelimiter();

        assertThat(delimiter).isEqualTo(";;");
    }

    @Test
    void 빈_문자열을_0_문자열로_대신한다() {
        String[] arr = {"1","","2"};
        String[] expected = {"1","0","2"};
        StringSplitter stringSplitter = new StringSplitter("");

        String[] result = stringSplitter.convertEmptyToZero(arr);

        assertArrayEquals(expected, result);
    }

    @Test
    void 문자열을_구분자로_나눈_배열을_반환한다() {
        String str = "//;;\n6;;0;;34;;45";
        StringSplitter stringSplitter = new StringSplitter(str);
        assertArrayEquals(new String[] {"6", "0", "34", "45"}, stringSplitter.split());

        String str2 = "6,,34;45";
        StringSplitter stringSplitter2 = new StringSplitter(str2);
        assertArrayEquals(new String[] {"6", "0", "34", "45"}, stringSplitter2.split());

        String str3 = "5";
        StringSplitter stringSplitter3 = new StringSplitter(str3);
        assertArrayEquals(new String[]{"5"}, stringSplitter3.split());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열을_나눌_경우_0으로_대신해_반환한다(String input) {
        String[] result = {"0"};

        StringSplitter stringSplitter = new StringSplitter(input);

        assertArrayEquals(result, stringSplitter.split());
    }
}