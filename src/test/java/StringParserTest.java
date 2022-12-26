import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringParserTest {

    @Test
    void parseSplitter_properInputWithSplitter() {
        String s = "//;\nteststring";
        StringParser sp = new StringParser();
        Assertions.assertThat(sp.parseSplitter(s)).isEqualTo(';');
    }

    @Test
    void parseSplitter_properInputWithoutSplitter() {
        String s = "teststring";
        StringParser sp = new StringParser();
        Assertions.assertThat(sp.parseSplitter(s)).isNull();
    }

    @Test
    void parseSplitter_improperInput() {
        StringParser sp = new StringParser();

        String s = "//teststring";
        Assertions.assertThat(sp.parseSplitter(s)).isNull();

        String s1 = "\ntestString";
        Assertions.assertThat(sp.parseSplitter(s1)).isNull();
    }

    @Test
    void parseTargetString_properInputWithSplitter() {
        String s = "//;\ntest,string:test;";
        StringParser sp = new StringParser();

        Assertions.assertThat(sp.splitTargetString(sp.parseTargetString(s), sp.parseSplitter(s))).isEqualTo(new String[]{"test", "string", "test", ""});
    }

    @Test
    void parseTargetString_properInputWithoutSplitter() {
        String s = ":test,string:test";
        StringParser sp = new StringParser();
        Assertions.assertThat(sp.splitTargetString(sp.parseTargetString(s), sp.parseSplitter(s))).isEqualTo(new String[]{"", "test", "string", "test"});
    }

    @Test
    void parseTargetString_improperInput() {
        StringParser sp = new StringParser();

        String s = "//test,string";
        Assertions.assertThat(sp.splitTargetString(sp.parseTargetString(s), sp.parseSplitter(s))).isEqualTo(new String[]{"//test", "string"});

        String s1 = "\ntest:String";
        Assertions.assertThat(sp.splitTargetString(sp.parseTargetString(s1), sp.parseSplitter(s1))).isEqualTo(new String[]{"\ntest", "String"});
    }

    @Test
    void castStringToInteger() {
        StringParser sp = new StringParser();
        String[] s0 = new String[]{"1", "2", "213123123", null, ""};
        for (String s : s0) {
            Assertions.assertThatNoException().isThrownBy(() -> sp.castStringToInteger(s));
        }

        String[] s1 = new String[]{"-1", "!@#", "1e9"};
        for (String s : s1) {
            Assertions.assertThatRuntimeException().isThrownBy(() -> sp.castStringToInteger(s));
        }
    }
}
