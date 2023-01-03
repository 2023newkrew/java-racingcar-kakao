package stringadder;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class StringProcessorTest {

    @Test
    void checkSplitTokenExist() {
        StringProcessor stringProcessor = new StringProcessor("//;\\n1;2;3");
        StringProcessResult stringProcessResult = stringProcessor.getStringProcessResult();
        assertThat(stringProcessResult).isEqualTo(new StringProcessResult(";", "1;2;3"));
    }

    @Test
    void checkSplitTokenNone() {
        StringProcessor stringProcessor = new StringProcessor("1;2;3");
        StringProcessResult stringProcessResult = stringProcessor.getStringProcessResult();
        assertThat(stringProcessResult).isEqualTo(new StringProcessResult(null, "1;2;3"));
    }
}
