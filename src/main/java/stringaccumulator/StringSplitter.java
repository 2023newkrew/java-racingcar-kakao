package stringaccumulator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringSplitter {

    private static final List<String> DEFAULT_SEPARATORS = List.of(",", ":");
    static final String PREFIX = "//";
    static final String SUFFIX = "\n";
    private static final int PREFIX_LENGTH = PREFIX.length();
    private static final int SUFFIX_LENGTH = SUFFIX.length();

    List<String> separators;

    public static StringSplitter from(String separatorFormat) {
        return new StringSplitter(separatorFormat);
    }

    private StringSplitter(String separatorFormat) {
        separators = new ArrayList<>(DEFAULT_SEPARATORS);
        if (separatorFormat == null)
            return;
        checkFormatValidation(separatorFormat);
        addCustomSeparator(separatorFormat);
    }

    private static void checkFormatValidation(String separatorFormat) {
        if (isInvalidFormat(separatorFormat)) {
            throw new RuntimeException("Invalid separator format.");
        }
    }

    private static boolean isInvalidFormat(String separatorFormat) {
        return !separatorFormat.startsWith(PREFIX) || !separatorFormat.endsWith(SUFFIX);
    }

    private void addCustomSeparator(String separatorFormat) {
        int lengthWithoutSuffix = separatorFormat.length() - SUFFIX_LENGTH;
        String customSeparator = separatorFormat.substring(PREFIX_LENGTH, lengthWithoutSuffix);
        if (!customSeparator.isEmpty())
            separators.add(0, customSeparator);
    }

    public boolean contains(String separator) {
        return separators.contains(separator);
    }

    public List<String> split(String content) {
        String splitRegex = getSplitRegex();
        return List.of(content.split(splitRegex));
    }

    private String getSplitRegex() {
        return separators.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}
