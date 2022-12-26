import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @Test
    void splitWithDefaultDelimiter() {
        String input = "1,2;3";
        StringUtil stringUtil = new StringUtil();
        String[] result = stringUtil.split(input);
        Assertions.assertThat(result).hasSize(3);
    }

    @Test
    void splitWithCustomDelimiter() {
        String input = "1:2,3;4";
        StringUtil stringUtil = new StringUtil();
        String[] result = stringUtil.split(input, ":");
        Assertions.assertThat(result).hasSize(4);
    }
}
