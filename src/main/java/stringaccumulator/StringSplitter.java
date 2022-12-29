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

    private final List<String> separators;

    private StringSplitter(List<String> separators) {
        this.separators = separators;
    }

    public static StringSplitter from(String separatorFormat) {
        if (separatorFormat == null) {
            return new StringSplitter(DEFAULT_SEPARATORS);
        }
        checkFormatValidation(separatorFormat);
        return new StringSplitter(addCustomSeparator(separatorFormat));
    }


    private static void checkFormatValidation(String separatorFormat) {
        if (isInvalidFormat(separatorFormat)) {
            throw new RuntimeException("Invalid separator format.");
        }
    }

    private static boolean isInvalidFormat(String separatorFormat) {
        return !separatorFormat.startsWith(PREFIX) || !separatorFormat.endsWith(SUFFIX);
    }

    private static List<String> addCustomSeparator(String separatorFormat) {
        int lengthWithoutSuffix = separatorFormat.length() - SUFFIX_LENGTH;
        String customSeparator = separatorFormat.substring(PREFIX_LENGTH, lengthWithoutSuffix);
        if (!customSeparator.isEmpty()) {
            return getSeparatorsWithCustom(customSeparator);
        }
        return DEFAULT_SEPARATORS;
    }

    private static List<String> getSeparatorsWithCustom(String customSeparator) {
        List<String> separatorsWithCustomSeparator = new ArrayList<>(DEFAULT_SEPARATORS);
        separatorsWithCustomSeparator.add(0, customSeparator);
        return List.copyOf(separatorsWithCustomSeparator);
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
