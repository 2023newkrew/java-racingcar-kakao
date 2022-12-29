package stringaccumulator;

public class SeparatorParser {

    private static final String PREFIX = "//";

    private static final String SUFFIX = "\n";

    private static final int PREFIX_LENGTH = PREFIX.length();

    private final String str;

    private final int suffixIndex;

    public static SeparatorParser from(String str) {
        if (isInvalidString(str)) {
            throw new RuntimeException("Invalid string.");
        }
        int suffixIndex = str.indexOf(SUFFIX);
        return new SeparatorParser(str, suffixIndex);
    }

    private static boolean isInvalidString(String str) {
        return str.startsWith(PREFIX) && !str.contains(SUFFIX);
    }

    private SeparatorParser(String str, int suffixIndex) {
        this.str = str;
        this.suffixIndex = suffixIndex;
    }

    public String parseSeparator() {
        if (suffixIndex == -1) {
            return "";
        }
        return str.substring(PREFIX_LENGTH, suffixIndex);
    }

    public String parseContent() {
        return str.substring(suffixIndex + 1);
    }
}
