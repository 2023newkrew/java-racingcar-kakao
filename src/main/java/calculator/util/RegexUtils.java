package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    public static Pattern compile(String regex) {
        return Pattern.compile(regex);
    }

    public static Matcher getMatcherForInput(String regex, String input) {
        return compile(regex).matcher(input);
    }
}
