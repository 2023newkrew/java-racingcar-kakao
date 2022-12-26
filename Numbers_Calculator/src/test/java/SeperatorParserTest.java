import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

public class SeperatorParserTest {
    private SeperatorParser seperatorParser;

    @BeforeEach
    public void setUp(){
        this.seperatorParser = new SeperatorParser();
    }

    @Test
    public void extractCustomSeperator() {
        String seperator = seperatorParser.extract("//.232\n1");

        Assertions.assertThat(seperator).isEqualTo(Pattern.quote(".232"));
    }

    @Test
    public void extractCustomSeperatorNotMatch() {
        String seperator = seperatorParser.extract("/.232\n1");
        Assertions.assertThat(seperator).isEqualTo(",|:");
    }



}
