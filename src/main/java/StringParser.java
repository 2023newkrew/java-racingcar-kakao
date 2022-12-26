import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final Character[] BASIC_SPLITTER = new Character[]{',', ':'};

    public Character parseSplitter(String s) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
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

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (Character ch : splitters) {
            sb.append(ch);
        }
        sb.append("]");

        return s.split(sb.toString(), -1);
    }
    public String parseTargetString(String s) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
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
        throw new RuntimeException();
    }
}
