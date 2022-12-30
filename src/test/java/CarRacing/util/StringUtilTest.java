package CarRacing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {
    @DisplayName("문자열을 잘 스플릿하는지 테스트")
    @Test
    public void splitStringTest() {
        assertThat(StringUtil.splitString("pobi,crong,honux", ",")).isEqualTo(new String[]{"pobi", "crong", "honux"});
    }
}
