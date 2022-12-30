package numberCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static numberCalculator.SeparatorParser.DEFAULT_STRING_SEPARATOR;

public class SeparatorParserTest {
    private SeparatorParser SeparatorParser;

    @BeforeEach
    public void setUp(){
        this.SeparatorParser = new SeparatorParser();
    }

    @Test
    public void extractCustomSeparator() {
        String Separator = SeparatorParser.extract("//.232\n1");

        Assertions.assertThat(Separator).isEqualTo(Pattern.quote(".232"));
    }

    @Test
    public void extractCustomSeparatorNotMatch() {
        String Separator = SeparatorParser.extract("/.232\n1");
        Assertions.assertThat(Separator).isEqualTo(DEFAULT_STRING_SEPARATOR);
    }
}
