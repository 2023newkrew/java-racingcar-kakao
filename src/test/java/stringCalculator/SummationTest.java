package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringCalculator.domain.Summation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SummationTest {

    private Summation summation;
    private String delimiterRegex = ",|:";
    private String customDelimiterRegex = "*";

    @DisplayName("숫자가 아닌 문자가 포함되어있을 때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "1:a:2", "1,ㄱ:a"})
    public void numberFormatExceptionTest(String inputWithCharacter) {
        summation = new Summation(inputWithCharacter);
        assertThrows(NumberFormatException.class, () -> summation.calculate(delimiterRegex));
    }

    @DisplayName("음수가 포함되어있을 때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,-1", "1:-1:2", "-1,1:2"})
    public void illegalArgumentExceptionTest(String inputWithNegativeNumber) {
        summation = new Summation(inputWithNegativeNumber);
        assertThrows(IllegalArgumentException.class, () -> summation.calculate(delimiterRegex));
    }

    @DisplayName("이스케이프 문자가 필요한 커스텀 구분자가 입력되었을 때 테스트")
    @Test
    public void customDelimiterEscapeExceptionTest() {
        summation = new Summation("1*2*3*4");
        assertThat(summation.calculate(customDelimiterRegex)).isEqualTo(10);
    }

    @DisplayName("모든 요소가 양수로 이루어져 있고 디폴트 구분자를 가지는 입력 문자열 테스트")
    @Test
    public void calculateTest() {
        summation = new Summation("1:2,3");
        assertThat(summation.calculate(delimiterRegex)).isEqualTo(6);
    }

}
