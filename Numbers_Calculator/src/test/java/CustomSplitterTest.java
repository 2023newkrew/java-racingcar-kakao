import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomSplitterTest {
    private Calculator calculator;
    private SeperatorParser seperatorParser;

    @BeforeEach
    public void setUp(){
        this.calculator = new Calculator();
        this.seperatorParser = new SeperatorParser();
    }

    @Test
    public void extractCustomSeperator() {
        String seperator = seperatorParser.extract("//.232\n1");

        Assertions.assertThat(seperator).isEqualTo(".232");
    }

    @Test
    public void extractCustomSeperatorNotMatch() {
        String seperator = seperatorParser.extract("/.232\n1");
        Assertions.assertThat(seperator).isEqualTo(",|:");
    }

    @Test
    public void splitWithCustomSeperator() {
        String seperator = seperatorParser.extract("//.\n1.2.3");

        Integer summary = calculator.summarizeNumbers("1.2.3", seperator);
        Assertions.assertThat(summary).isEqualTo(6);
    }

}
