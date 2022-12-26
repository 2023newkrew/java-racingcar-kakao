import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringParserTest {

    @Test
    void splitWithDefaultDelimiter() {
        String input = "1,2;3";
        StringParser stringParser = new StringParser();
        String[] result = stringParser.split(input);
        Assertions.assertThat(result).hasSize(3);
    }

    @Test
    void splitWithCustomDelimiter() {
        String input = "1:2,3;4";
        StringParser stringParser = new StringParser();
        String[] result = stringParser.split(input, ":");
        Assertions.assertThat(result).hasSize(4);
    }
}
