package stringaccumulator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        List<String> splitTokens = parseContentBySeparator(separator, content);
        checkIsPositiveNumber(splitTokens);
        return getSum(splitTokens);
    }

    static List<String> parseContentBySeparator(String separator, String content) {
        return StringSplitter.from(separator)
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

    public boolean equalsTo(String separator, String content) {
        return Objects.equals(this.separator, separator) &&
                Objects.equals(this.content, content);
    }
}
