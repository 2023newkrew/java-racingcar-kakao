package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void emptyString() {
        StrCal emptyStr = new StrCal("");
        assertThat(emptyStr.calculate()).equalTo(0);
    }

    @Test
    void nullString() {
        StrCal nullStr = new StrCal(null);
        assertThat(nullStr.calculate()).equalTo(0);
    }
}
