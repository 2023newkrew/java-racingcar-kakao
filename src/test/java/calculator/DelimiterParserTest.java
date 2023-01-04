package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class DelimiterParserTest {

    private static final List<String> defaultDelimiters = Arrays.asList(",", ":");

    @Test
    @DisplayName("사용자 정의 구분자가 있을 때 True를 반환한다.")
    void checkCustomMatch() {
        DelimiterParser delimiter = new DelimiterParser("//?\n1?2?3", defaultDelimiters);
        Assertions.assertThat(delimiter.hasCustomDelimiter()).isTrue();
    }

    @Test
    @DisplayName("입력 문자열에서 사용자 정의 구분자가 없을 때 False를 반환한다.")
    void checkNotCustomMatch() {
        DelimiterParser delimiter = new DelimiterParser("1:2:3", defaultDelimiters);
        Assertions.assertThat(delimiter.hasCustomDelimiter()).isFalse();
    }

    @Test
    @DisplayName("사용자 정의 구분자가 없을 때 Default 구분자로 설정후 반환한다.")
    void checkDefaultDelimiter() {
        DelimiterParser delimiter = new DelimiterParser("1:2:3", defaultDelimiters);
        Assertions.assertThat(delimiter.getDelimiter()).isEqualTo(",|:");
    }

    @Test
    @DisplayName("사용자 정의 구분자가 있을때 사용자 정의 구분자로 설정후 반환한다.")
    void checkCustomDelimiter() {
        DelimiterParser delimiter = new DelimiterParser("//?\n1?2?3", defaultDelimiters);
        Assertions.assertThat(delimiter.getDelimiter()).isEqualTo("?");
        Assertions.assertThat(delimiter.getProcessedInput()).isEqualTo("1?2?3");
    }
}
