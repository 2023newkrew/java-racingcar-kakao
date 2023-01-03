package numberCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static numberCalculator.SeparatorParser.DEFAULT_STRING_SEPARATOR;

public class SeparatorParserTest {
    private SeparatorParser separatorParser;

    @BeforeEach
    public void setUp(){
        this.separatorParser = new SeparatorParser();
    }

    @Test
    public void extractCustomSeparator() {
        String separator = separatorParser.extract("//.232\n1");

        Assertions.assertThat(separator).isEqualTo(Pattern.quote(".232"));
    }

    @Test
    public void extractCustomSeparatorNotMatch() {
        String separator = separatorParser.extract("/.232\n1");
        Assertions.assertThat(separator).isEqualTo(DEFAULT_STRING_SEPARATOR);
    }
}
