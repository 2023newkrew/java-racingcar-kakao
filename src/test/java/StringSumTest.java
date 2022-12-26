import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSumTest {

    private StringSum stringSum;
    private StringSum customStringSum;
    private String[] testList;

    @BeforeEach
    void setUp() {
        customStringSum = new StringSum("//;\n1;2;3");
        stringSum = new StringSum("1:2,3");

        testList = new String[] {"1", "2", "3"};
    }

    @Test
    public void customDelimiterTest() {
        String customDelimiter = customStringSum.customDelimiter();
        assertThat(customDelimiter).isEqualTo(";");
    }

}
