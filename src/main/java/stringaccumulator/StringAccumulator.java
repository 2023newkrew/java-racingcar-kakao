package stringaccumulator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringAccumulator {

    private final String separator;
    private final String content;
    private final StringSplitter stringSplitter;

    StringAccumulator(String separator, String content, StringSplitter stringSplitter) {
        this.separator = separator;
        this.content = content;
        this.stringSplitter = stringSplitter;
    }

    public static StringAccumulator from(String str) {
        String content = str;
        String separator = null;
        if (hasSeparator(str)) {
            int newlineNextIndex = getNewlineIndex(str) + 1;
            separator = str.substring(0, newlineNextIndex);
            content = str.substring(newlineNextIndex);
        }
        return new StringAccumulator(separator, content, StringSplitter.from(separator));
    }

    private static boolean hasSeparator(String str) {
        return str.startsWith("//");
    }

    private static int getNewlineIndex(String str) {
        int newlineIndex = str.indexOf("\n");
        if (newlineIndex == -1) {
            throw new RuntimeException("Invalid string.");
        }
        return newlineIndex;
    }

    public long accumulate() {
        List<String> splitTokens = parseContentBySplitter(stringSplitter, content);
        checkIsPositiveNumber(splitTokens);
        return getSum(splitTokens);
    }

    static List<String> parseContentBySplitter(StringSplitter splitter, String content) {
        return splitter
                .split(content)
                .stream()
                .map(String::trim)
                .filter(token -> !token.isBlank())
                .collect(Collectors.toList());
    }

    private static void checkIsPositiveNumber(List<String> splitTokens) {
        if (splitTokens.stream().anyMatch(StringAccumulator::isNotNumeric)) {
            throw new RuntimeException("숫자가 아닌 토큰이 포함되어 있습니다.");
        }
        if (splitTokens.stream().anyMatch(StringAccumulator::isNegative)) {
            throw new RuntimeException("음수는 포함할 수 없습니다.");
        }
    }

    private static boolean isNotNumeric(String str) {
        try {
            Long.parseLong(str);
            return false;
        } catch (NumberFormatException ignore) {
            return true;
        }
    }

    private static long getSum(List<String> splitTokens) {
        return splitTokens.stream()
                .mapToLong(Long::parseLong)
                .sum();
    }

    private static boolean isNegative(String str) {
        return Long.parseLong(str) < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringAccumulator that = (StringAccumulator) o;
        return Objects.equals(separator, that.separator) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(separator, content);
    }
}
