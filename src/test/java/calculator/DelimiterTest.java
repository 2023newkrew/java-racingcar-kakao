package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



public class DelimiterTest {
    @Test
    void checkCustomMatch() {
        Delimiter delimiter = new Delimiter("//?\n1?2?3");
        Assertions.assertThat(delimiter.hasCustomMatch()).isTrue();
    }

    @Test
    void checkNotCustomMatch() {
        Delimiter delimiter = new Delimiter("1:2:3");
        Assertions.assertThat(delimiter.hasCustomMatch()).isFalse();
    }

    @Test
    void checkDefaultDelimiter() {
        Delimiter delimiter = new Delimiter("1:2:3");
        delimiter.checkCustomDelimiter();
        Assertions.assertThat(delimiter.getDelimiter()).isEqualTo(",|:");
    }

    @Test
    void checkCustomDelimiter() {
        Delimiter delimiter = new Delimiter("//?\n1?2?3");
        delimiter.checkCustomDelimiter();
        Assertions.assertThat(delimiter.getDelimiter()).isEqualTo("?");
    }
}
