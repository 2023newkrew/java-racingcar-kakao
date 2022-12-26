package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerList {

    private List<Integer> list;

    public IntegerList(String[] arr) {
        list = Arrays.stream(arr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int calculateSum() {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
