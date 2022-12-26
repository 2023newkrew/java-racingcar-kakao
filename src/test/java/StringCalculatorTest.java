import domain.TargetString;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    void nullTest() {
        TargetString targetString = new TargetString(null);
        assertThat(targetString.calculate()).isEqualTo(0);
    }

    @Test
    void emptyTest() {
        TargetString targetString = new TargetString("");
        assertThat(targetString.calculate()).isEqualTo(0);
    }

    @Test
    void oneNumberTest() {
        TargetString targetString = new TargetString("1");
        assertThat(targetString.calculate()).isEqualTo(1);
    }
    @Test
    void commaTest() {
        TargetString targetString = new TargetString("1,2");
        assertThat(targetString.calculate()).isEqualTo(3);
    }

    @Test
    void colonTest() {
        TargetString targetString = new TargetString("1:2");
        assertThat(targetString.calculate()).isEqualTo(3);
    }

    @Test
    void commaColonTest() {
        TargetString targetString = new TargetString("1,2:3");
        assertThat(targetString.calculate()).isEqualTo(6);
    }

    @Test
    void customDelimiterTest() {
        TargetString targetString = new TargetString("//;\n1;2");
        assertThat(targetString.calculate()).isEqualTo(3);
    }

    @Test
    void allDelimiterTest() {
        TargetString targetString = new TargetString("//A\n1,2:3A4");
        assertThat(targetString.calculate()).isEqualTo(10);
    }
}
