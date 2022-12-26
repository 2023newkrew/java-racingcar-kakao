package stringaccumulator;

import java.util.Objects;

public class StringAccumulator {

    String separator;
    String content;

    private StringAccumulator(String str) {
        content = str;
        if (hasSeparator(str)) {
            int newlineNextIndex = getNewlineIndex(str) + 1;
            separator = str.substring(0, newlineNextIndex);
            content = str.substring(newlineNextIndex);
        }
    }

    private static boolean hasSeparator(String str) {
        return str.startsWith("//");
    }

    private static int getNewlineIndex(String str) {
        int newlineIndex = str.indexOf("\n");
        if (newlineIndex == -1)
            throw new RuntimeException("Invalid string.");
        return newlineIndex;
    }

    public static StringAccumulator from(String str) {
        return new StringAccumulator(str);
    }

    public long accumulate() {
        return 0;
    }

    public boolean equalsTo(String separator, String content) {
        return Objects.equals(this.separator, separator) &&
                Objects.equals(this.content, content);
    }
}
