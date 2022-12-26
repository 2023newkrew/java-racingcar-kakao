package stringcalc;

import java.util.List;

public class Calculator {
    public Long sum(List<Long> numbers) {
        return numbers.stream().reduce(0L, Long::sum);
    }
}
