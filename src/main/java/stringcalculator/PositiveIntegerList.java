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

    public static void validate(String[] arr) {
        if (arr.length == 0) {
            throw new RuntimeException();
        }

        Arrays.stream(arr)
                .map(Integer::parseInt)
                .filter(value -> value < 0)
                .findAny()
                .ifPresent(value -> { throw new RuntimeException(); });
    }
}