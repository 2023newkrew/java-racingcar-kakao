package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveIntegerList {

    private final List<Integer> list;

    public PositiveIntegerList(String[] arr) {
        list = Arrays.stream(arr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int calculateSum() {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public void validate() {
        list.stream()
                .filter(value -> value < 0)
                .findAny()
                .ifPresent(value -> { throw new RuntimeException(); });
    }
}
