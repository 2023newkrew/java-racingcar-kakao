import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private static final String SPLITTER_REGEX = "//(.)\\\\n(.*)";
    private static final Character[] BASIC_SPLITTER = new Character[]{',', ':'};

    public Character parseSplitter(String s) {
        Matcher m = Pattern.compile(SPLITTER_REGEX).matcher(s);
        if (m.find()) {
            return m.group(1).charAt(0);
        }
        return null;
    }

    public String[] splitTargetString(String s, Character splitter) {
        ArrayList<Character> splitters = new ArrayList<Character>(List.of(BASIC_SPLITTER));

        if (splitter != null) {
            splitters.add(splitter);
        }

        return s.split(buildRegexPatternFromSplitterArray(splitters), -1);
    }

    private String  buildRegexPatternFromSplitterArray(ArrayList<Character> splitters) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (Character ch : splitters) {
            sb.append(ch);
        }
        sb.append("]");

        return sb.toString();
    }

    public String parseTargetString(String s) {
        Matcher m = Pattern.compile(SPLITTER_REGEX).matcher(s);

        if (m.find()) {
            return m.group(2);
        }

        return s;
    }

    public Integer castStringToInteger(String s) {
        if (StringVerifier.isNullOrEmpty(s)) {
            return 0;
        }
        if (StringVerifier.isInteger(s) && StringVerifier.isPositive(Integer.parseInt(s))) {
            return Integer.parseInt(s);
        }
        throw new RuntimeException("Invalid input! start again.");
    }
}
