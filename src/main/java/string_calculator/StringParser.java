package string_calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final Character[] BASIC_SPLITTER = new Character[]{',', ':'};
    private static final Pattern PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private static final int CUSTOM_SPLITTER_INDEX = 1;
    private static final int TARGET_STRING_INDEX = 2;

    public Integer[] parse(String s) {
        if (StringVerifier.isNullOrEmpty(s)) {
            return new Integer[] {0};
        }
        Character splitter = parseSplitter(s);
        String targetString = parseTargetString(s);
        String[] targetStringArray = splitTargetString(targetString, splitter);
        return Arrays.stream(targetStringArray)
                .map(this::castStringToInteger)
                .toArray(Integer[]::new);
    }

    private Character parseSplitter(String s) {
        Matcher m = PATTERN.matcher(s);
        if (m.find()) {
            return m.group(CUSTOM_SPLITTER_INDEX).charAt(0);
        }
        return null;
    }

    private String[] splitTargetString(String s, Character splitter) {
        ArrayList<Character> splitters = new ArrayList<Character>(List.of(BASIC_SPLITTER));

        if (splitter != null) {
            splitters.add(splitter);
        }

        return s.split(buildRegexPatternFromSplitterArray(splitters), -1);
    }

    private String buildRegexPatternFromSplitterArray(ArrayList<Character> splitters) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (Character ch : splitters) {
            sb.append(ch);
        }
        sb.append("]");

        return sb.toString();
    }

    private String parseTargetString(String s) {
        Matcher m = PATTERN.matcher(s);

        if (m.find()) {
            return m.group(TARGET_STRING_INDEX);
        }

        return s;
    }

    private Integer castStringToInteger(String s) {
        if (StringVerifier.isNullOrEmpty(s)) {
            return 0;
        }
        if (StringVerifier.isInteger(s) && StringVerifier.isPositive(Integer.parseInt(s))) {
            return Integer.parseInt(s);
        }
        throw new RuntimeException("Invalid input! start again.");
    }
}
