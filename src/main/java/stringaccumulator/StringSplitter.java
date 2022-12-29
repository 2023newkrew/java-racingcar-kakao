package stringaccumulator;

import java.util.List;
import java.util.Objects;

public class StringSplitter {

    private static final StringSplitter defaultSplitter = new StringSplitter(null);

    private static final List<String> DEFAULT_SEPARATORS = List.of(",", ":");

    private static final String DELIMITER = "|";

    private final String customSeparator;

    public static StringSplitter getDefaultSplitter() {
        return defaultSplitter;
    }

    public static StringSplitter from(String customSeparator) {
        if (isNullOrEmpty(customSeparator)) {
            return getDefaultSplitter();
        }
        return new StringSplitter(customSeparator);
    }

    private static boolean isNullOrEmpty(String customSeparator) {
        return Objects.isNull(customSeparator) || customSeparator.isEmpty();
    }

    private StringSplitter(String customSeparator) {
        this.customSeparator = customSeparator;
    }

    public List<String> split(String content) {
        if (Objects.isNull(content)) {
            return List.of("");
        }
        String splitRegex = String.join(DELIMITER, DEFAULT_SEPARATORS);
        if (!isNullOrEmpty(customSeparator)) {
            splitRegex = customSeparator + DELIMITER + splitRegex;
        }
        return List.of(content.split(splitRegex));
    }
}
