package stringaccumulator;

import java.util.ArrayList;
import java.util.List;

public class StringSplitter {

    private static final List<String> DEFAULT_SEPARATORS = List.of(",", ":");
    private static final String PREFIX = "//";
    private static final String SUFFIX = "\n";
    private static final int PREFIX_LENGTH = PREFIX.length();
    private static final int SUFFIX_LENGTH = SUFFIX.length();

    List<String> separators;

    public static StringSplitter from(String separatorFormat) {
        return new StringSplitter(separatorFormat);
    }

    private StringSplitter(String separatorFormat) {
        checkFormatValidation(separatorFormat);
        separators = new ArrayList<>(DEFAULT_SEPARATORS);
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
            separators.add(customSeparator);
    }

    public boolean contains(String separator) {
        return separators.contains(separator);
    }

    public List<String> split(String content) {
        return null;
    }
}
