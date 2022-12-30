package stringadder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAdderTest {

    private StringAdder stringAdder;

    @BeforeEach
    void setUp() {
        stringAdder = new StringAdder();
    }

    @Test
    @DisplayName("주어진 text가 null 이면 0을 리턴해야 한다.")
    public void ifNullReturnZero() {
        String text = null;
        int result = stringAdder.add(text);
        assertThat(result).isEqualTo(StringAdderConstant.IS_NULL_OR_BLANK);
    }

    @Test
    @DisplayName("주어진 text가 empty 이면 0을 리턴해야 한다.")
    public void ifEmptyReturnZero() {
        String text = "";
        int result = stringAdder.add(text);
        assertThat(result).isEqualTo(StringAdderConstant.IS_NULL_OR_BLANK);
    }


    @Test
    @DisplayName("주어진 text가 blank 이면 0을 리턴해야 한다.")
    public void ifBlankReturnZero() {
        String text = "   ";
        int result = stringAdder.add(text);
        assertThat(result).isEqualTo(StringAdderConstant.IS_NULL_OR_BLANK);
    }


    @Test
    @DisplayName("단일 숫자가 String으로 주어지면 해당 숫자를 parsing한 값이 리턴돼야 한다.")
    public void parseIntTest() {
        String text = "2";
        int result = stringAdder.add(text);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("문자열로 숫자가 아닌 문자가 주어지면 에러가 발생해야 한다.")
    public void parseAnotherTest() {
        String text = "a";
        assertThatThrownBy(() -> stringAdder.add(text)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열이 . 기준으로 문자열이 나뉘어야 한다.")
    public void commaSplitTextTest() {
        String text = "2,5,3";
        String[] numbers = stringAdder.split(text);
        assertThat(numbers).containsExactly("2", "5", "3");
    }

    @Test
    @DisplayName("문자열이 ; 기준으로 문자열이 나뉘어야 한다.")
    public void semicolonSplitTextTest() {
        String text = "2;5;3";
        String[] numbers = stringAdder.split(text);
        assertThat(numbers).containsExactly("2", "5", "3");
    }

    @Test
    @DisplayName("문자열이 custom delimiter로 나뉘어야 한다.")
    public void customDelimiterTest() {
        String text = "//s\n1s2s3";
        String[] numbers = stringAdder.split(text);
        assertThat(numbers).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("custom과 (;), (.)으로 parsing이 가능해야 한다.")
    public void variousDelimiterTest() {
        String text = "//s\n1s2;3,4";
        assertThat(stringAdder.add(text)).isEqualTo(10);
    }

    @Test
    @DisplayName("negative value가 주어지면 RuntimeException이 발생해야 한다.")
    public void ifNegativeThrowRuntimeException() {
        String text = "-1,2,3";

        assertThatThrownBy(() -> {
            stringAdder.isValid(stringAdder.stringToInts(stringAdder.split(text)));
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("문자열 덧셈결과가 일치해야 한다.")
    public void sumTest() {
        String[] numbers = {"1", "2", "3"};
        String[] numbers2 = {"1", "2", "3", "4"};
        int result = stringAdder.sum(stringAdder.stringToInts(numbers));
        assertThat(result).isEqualTo(6);
        result = stringAdder.sum(stringAdder.stringToInts(numbers2));
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("0에 대해서 처리가 되어야 한다.")
    public void addTest() {
        String text = "1,0,3";
        int result = stringAdder.add(text);
        assertThat(result).isEqualTo(4);

    }

    @Test
    @DisplayName("custom delimiter만 주어지면 남은 문자열이 blank이므로 0이 리턴되어야 한다.")
    public void addTest2() {
        String text = "//s\n";
        int result = stringAdder.add(text);
        assertThat(result).isEqualTo(0);

    }
}
