package stringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringCalculator.domain.Delimiter;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterTest {

    private String delimiterRegEx;
    private String customDelimiterRegEx;
    private String inputString;
    private String customInputString;
    private String modifiedCustomInputString;
    private Delimiter delimiter;
    private Delimiter customDelimiter;

    @BeforeEach
    void setUp() {
        delimiterRegEx = ",|:";
        customDelimiterRegEx = ";";
        inputString = "1:2,3";
        customInputString = "//;\\n1;2;3";
        modifiedCustomInputString = "1;2;3";
        delimiter = new Delimiter(inputString);
        customDelimiter = new Delimiter(customInputString);
    }

    @DisplayName("구분자를 따로 정의하지 않은 경우 구분자 추출 테스트")
    @Test
    public void getDelimiterRegExTest() {
        assertThat(delimiter.getDelimiterRegEx()).isEqualTo(delimiterRegEx);
    }

    @DisplayName("구분자를 따로 정의하지 않은 경우 문자열 추출 테스트")
    @Test
    public void getInputStringTest() {
        assertThat(delimiter.getInputString()).isEqualTo(inputString);
    }

    @DisplayName("커스텀 구분자를 정의한 경우 구분자 추출 테스트")
    @Test
    public void getCustomDelimiterRegExTest() {
        assertThat(customDelimiter.getDelimiterRegEx()).isEqualTo(customDelimiterRegEx);
    }

    @DisplayName("커스텀 구분자를 정의한 경우 문자열 추출 테스트")
    @Test
    public void getCustomInputStringTest() {
        assertThat(customDelimiter.getInputString()).isEqualTo(modifiedCustomInputString);
    }

}
