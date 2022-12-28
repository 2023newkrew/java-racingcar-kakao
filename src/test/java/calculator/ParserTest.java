package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {

    @Test
    @DisplayName("//와 \\n 사이에 주어진 문자를 구분자로 추가한다. - customDelimiter 추출")
    void addCustomDelimiterTest() {
        Parser parser = new Parser("//+\n1,2+3");

        assertThat(parser.getCustomDelimiter().get()).isEqualTo("+");
    }

    @Test
    @DisplayName("//와 \\n 사이에 주어진 문자를 구분자로 추가한다. - delimiter 관련 부분 제거")
    void deleteCustomDelimiterFromInputTest() {
        Parser parser = new Parser("//+\n1,2+3");

        parser.getCustomDelimiter();

        assertThat(parser.getContent()).isEqualTo("1,2+3");
    }
}
