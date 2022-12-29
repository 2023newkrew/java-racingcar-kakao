package string_addition_calculator;

// "1,2,3" -> "1","2","3"
// "1,a,2b" -> "1","a","2b"
// "1:2;3" -> "1","2","3"
// "1:5b,4,3" -> "1","5b","4","3"
// "//^\n1^2^3" -> "1","2","3"
// "//^\n1^2:3,4" -> "1","2","3","4"
// "//^\nabcd//s^39:sdijc," -> "nabcd//s","39","sdijc",""

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SplitterTest {

    Splitter splitter;

    @BeforeEach
    void SetUp() {
        splitter = new Splitter();
    }

    @Test
    void split1() {
        String[] result = splitter.split("1,2,3");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
        assertThat(result[2]).isEqualTo("3");
    }

    @Test
    void split2() {
        String[] result = splitter.split("1,a,2b");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("a");
        assertThat(result[2]).isEqualTo("2b");
    }

    @Test
    void split3() {
        String[] result = splitter.split("1:2:3");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
        assertThat(result[2]).isEqualTo("3");
    }

    @Test
    void split4() {
        String[] result = splitter.split( "1:5b,4,3");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("5b");
        assertThat(result[2]).isEqualTo("4");
        assertThat(result[3]).isEqualTo("3");
    }

    @Test
    void split5() {
        String[] result = splitter.split( "//^\n1^2^3");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
        assertThat(result[2]).isEqualTo("3");
    }

    @Test
    void split6() {
        String[] result = splitter.split( "//^\n1^2:3,4");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
        assertThat(result[2]).isEqualTo("3");
        assertThat(result[3]).isEqualTo("4");
    }

    @Test
    void split7() {
        String[] result = splitter.split( "//^\nabcd//s^39:sdijc,");
        assertThat(result[0]).isEqualTo("abcd//s");
        assertThat(result[1]).isEqualTo("39");
        assertThat(result[2]).isEqualTo("sdijc");
    }

    @Test
    void split8() {
        String[] result = splitter.split( "//a\nabcd//s^39:sdijc,");
        assertThat(result[0]).isEqualTo("");
        assertThat(result[1]).isEqualTo("bcd//s^39");
        assertThat(result[2]).isEqualTo("sdijc");
    }
}
