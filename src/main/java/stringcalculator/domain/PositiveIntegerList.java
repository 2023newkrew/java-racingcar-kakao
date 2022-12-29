package stringcalculator.domain;

import stringcalculator.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static stringcalculator.config.ErrorMessage.INPUT_ERROR_MESSAGE;

public class PositiveIntegerList {

    private List<Integer> list;

    public PositiveIntegerList(String[] values) {
        validateValues(values);
        list = Arrays.stream(values)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int calculateSum() {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void validateValues(String[] values) {
        Arrays.stream(values)
                .map(StringUtils::convertToInt)
                .filter(value -> value < 0)
                .findAny()
                .ifPresent(value -> { throw new RuntimeException(INPUT_ERROR_MESSAGE); });
    }

}
