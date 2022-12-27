package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class DelimiterParserTest {

    private static final List<String> defaultDelimiters = Arrays.asList(",", ":");
    @Test
    void checkCustomMatch() {
        DelimiterParser delimiter = new DelimiterParser("//?\n1?2?3", defaultDelimiters);
        Assertions.assertThat(delimiter.hasCustomMatch()).isTrue();
    }

    @Test
    void checkNotCustomMatch() {
        DelimiterParser delimiter = new DelimiterParser("1:2:3", defaultDelimiters);
        Assertions.assertThat(delimiter.hasCustomMatch()).isFalse();
    }

    @Test
    void checkDefaultDelimiter() {
        DelimiterParser delimiter = new DelimiterParser("1:2:3", defaultDelimiters);
        delimiter.checkCustomDelimiter();
        Assertions.assertThat(delimiter.getDelimiter()).isEqualTo(",|:");
    }

    @Test
    void checkCustomDelimiter() {
        DelimiterParser delimiter = new DelimiterParser("//?\n1?2?3", defaultDelimiters);
        delimiter.checkCustomDelimiter();
        Assertions.assertThat(delimiter.getDelimiter()).isEqualTo("?");
        Assertions.assertThat(delimiter.getPurifiedInput()).isEqualTo("1?2?3");
    }
}
