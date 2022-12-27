package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



public class DelimiterParserTest {
    @Test
    void checkCustomMatch() {
        DelimiterParser delimiter = new DelimiterParser("//?\n1?2?3");
        Assertions.assertThat(delimiter.hasCustomMatch()).isTrue();
    }

    @Test
    void checkNotCustomMatch() {
        DelimiterParser delimiter = new DelimiterParser("1:2:3");
        Assertions.assertThat(delimiter.hasCustomMatch()).isFalse();
    }

    @Test
    void checkDefaultDelimiter() {
        DelimiterParser delimiter = new DelimiterParser("1:2:3");
        delimiter.checkCustomDelimiter();
        Assertions.assertThat(delimiter.getDelimiter()).isEqualTo(",|:");
    }

    @Test
    void checkCustomDelimiter() {
        DelimiterParser delimiter = new DelimiterParser("//?\n1?2?3");
        delimiter.checkCustomDelimiter();
        Assertions.assertThat(delimiter.getDelimiter()).isEqualTo("?");
        Assertions.assertThat(delimiter.getPurifiedInput()).isEqualTo("1?2?3");
    }
}
