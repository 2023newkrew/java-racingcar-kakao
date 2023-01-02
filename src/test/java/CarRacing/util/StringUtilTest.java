package CarRacing.util;

import CarRacing.domain.CarName;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {
    private static final List<String> DUMMY_STRING_LIST = Arrays.asList("pobi", "crong", "honux");
    private static final String DUMMY_STRING = "pobi,crong,honux";

    @DisplayName("문자열을 잘 스플릿하는지 테스트")
    @Test
    public void splitStringTest() {
        assertThat(StringUtil.splitString(DUMMY_STRING, ",")).isEqualTo(new String[]{"pobi", "crong", "honux"});
    }

    @DisplayName("문자열을 숫자로 잘 바꾸는지 테스트")
    @Test
    public void convertStringToIntTest() {
        assertThat(StringUtil.convertStringToInt("5")).isEqualTo(5);
    }

    @DisplayName("자동차 이름 리스트를 String 리스트로 잘 바꾸는지 테스트")
    @Test
    public void convertCarNameListToStringListTest() {
        List<CarName> carNames = Arrays.asList(new CarName("pobi"), new CarName("crong"), new CarName("honux"));
        assertThat(StringUtil.convertCarNameListToStringList(carNames)).isEqualTo(DUMMY_STRING_LIST);
    }

    @DisplayName("String 리스트가 주어졌을 때 delimiter로 join하는 메소드 테스트")
    @Test
    public void joinStringListTest() {
        assertThat(StringUtil.joinStringList(",", DUMMY_STRING_LIST)).isEqualTo(DUMMY_STRING);
    }
}
