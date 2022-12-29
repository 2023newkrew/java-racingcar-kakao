package stringaccumulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringSplitter {

    private static final List<String> DEFAULT_SEPARATORS = List.of(",", ":");

    private static final String PREFIX = "//";

    private static final String SUFFIX = "\n";

    private static final int PREFIX_LENGTH = PREFIX.length();

    private static final int SUFFIX_LENGTH = SUFFIX.length();

    private final List<String> separators;

    public static StringSplitter from(String separatorFormat) {
        if (isNullOrBlank(separatorFormat)) {
            return new StringSplitter(DEFAULT_SEPARATORS);
        }
        checkFormatValidation(separatorFormat);
        String customSeparator = parseCustomSeparator(separatorFormat);
        List<String> separators = gerSeparatorsWith(customSeparator);
        return new StringSplitter(separators);
    }

    private static boolean isNullOrBlank(String separatorFormat) {
        return Objects.isNull(separatorFormat) || separatorFormat.isBlank();
    }

    private static void checkFormatValidation(String separatorFormat) {
        if (isInvalidFormat(separatorFormat)) {
            throw new RuntimeException("Invalid separator format.");
        }
    }

    private static boolean isInvalidFormat(String separatorFormat) {
        return !separatorFormat.startsWith(PREFIX) || !separatorFormat.endsWith(SUFFIX);
    }

    private static String parseCustomSeparator(String separatorFormat) {
        checkFormatValidation(separatorFormat);
        int lengthWithoutSuffix = separatorFormat.length() - SUFFIX_LENGTH;
        return separatorFormat.substring(PREFIX_LENGTH, lengthWithoutSuffix);
    }

    private static List<String> gerSeparatorsWith(String customSeparator) {
        List<String> separators = new ArrayList<>(DEFAULT_SEPARATORS);
        if (!customSeparator.isBlank()) {
            separators.add(customSeparator);
        }
        return separators;
    }

    private StringSplitter(List<String> separators) {
        this.separators = separators;
    }

    //Todo: 테스트에서만 사용하는 메소드 제거
    public boolean contains(String separator) {
        return separators.contains(separator);
    }

    public List<String> split(String content) {
        String splitRegex = String.join("|", separators);
        return List.of(content.split(splitRegex));
    }
}
