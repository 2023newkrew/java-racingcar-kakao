package stringaccumulator;

import java.util.Objects;
import java.util.function.Predicate;

public class StringAccumulator {

    private final StringSplitter stringSplitter;

    public static StringAccumulator from(StringSplitter stringSplitter) {
        if (Objects.isNull(stringSplitter)) {
            throw new RuntimeException("StringSplitter should be not null.");
        }
        return new StringAccumulator(stringSplitter);
    }

    private StringAccumulator(StringSplitter stringSplitter) {
        this.stringSplitter = stringSplitter;
    }

    public long accumulate(String content) {
        return stringSplitter.split(content)
                .stream()
                .map(String::trim)
                .filter(Predicate.not(String::isBlank))
                .mapToLong(Long::parseUnsignedLong)
                .sum();
    }
}
