package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



public class DelimiterParserTest {
    @Test
    void checkDefaultDelimiter() {
        DelimiterParser delimiter = new DelimiterParser("1:2:3");
       Assertions.assertThat(delimiter.getDelimiter()).isEqualTo(",|:");
    }

    @Test
    void checkCustomDelimiter() {
        DelimiterParser delimiter = new DelimiterParser("//?\n1?2?3");
        Assertions.assertThat(delimiter.getDelimiter()).isEqualTo("\\?");
        Assertions.assertThat(delimiter.getPurifiedInputSplit()).isEqualTo(new String[]{"1", "2", "3"});

        DelimiterParser delimiter2 = new DelimiterParser("//|\n1|2|3");
        Assertions.assertThat(delimiter2.getDelimiter()).isEqualTo("\\|");
        Assertions.assertThat(delimiter2.getPurifiedInputSplit()).isEqualTo(new String[]{"1", "2", "3"});
    }
}
