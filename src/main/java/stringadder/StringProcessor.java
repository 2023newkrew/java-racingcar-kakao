package stringadder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StringProcessor {
    private final String targetString;

    public StringProcessor(String targetString) {
        this.targetString = targetString;
    }

    public StringProcessResult getStringProcessResult() {
        Matcher m = Pattern.compile("//(.+)\\\\n(.*)").matcher(targetString);

        if (m.find()) {
            return new StringProcessResult(m.group(1), m.group(2));
        }
        return new StringProcessResult(null, targetString);

    }
}
