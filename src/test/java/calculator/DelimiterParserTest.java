package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class DelimiterParserTest {

    private static final List<String> defaultDelimiters = Arrays.asList(",", ":");
    @Test
    @DisplayName("사용자 정의 구분자 추출")
    void checkCustomMatch() {
        DelimiterParser delimiter = new DelimiterParser("//?\n1?2?3", defaultDelimiters);
        Assertions.assertThat(delimiter.hasCustomMatch()).isTrue();
    }

    @Test
    @DisplayName("입력 문자열에서 사용자 정의 구분자가 없을 때")
    void checkNotCustomMatch() {
        DelimiterParser delimiter = new DelimiterParser("1:2:3", defaultDelimiters);
        Assertions.assertThat(delimiter.hasCustomMatch()).isFalse();
    }

    @Test
    @DisplayName("사용자 정의 구분자가 없을 때 Default 구분자로 설정")
    void checkDefaultDelimiter() {
        DelimiterParser delimiter = new DelimiterParser("1:2:3", defaultDelimiters);
        delimiter.checkCustomDelimiter();
        Assertions.assertThat(delimiter.getDelimiter()).isEqualTo(",|:");
    }

    @Test
    @DisplayName("사용자 정의 구분자가 있을때 사용자 정의 구분자로 설정")
    void checkCustomDelimiter() {
        DelimiterParser delimiter = new DelimiterParser("//?\n1?2?3", defaultDelimiters);
        delimiter.checkCustomDelimiter();
        Assertions.assertThat(delimiter.getDelimiter()).isEqualTo("?");
        Assertions.assertThat(delimiter.getPurifiedInput()).isEqualTo("1?2?3");
    }
}
