package calculator;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    public void hasNegative(List<Integer> numbers){
        List<Integer> list =
                numbers.stream()
                        .filter(num -> num < 0)
                        .collect(Collectors.toList());

        if(list.size() > 0) throw new RuntimeException("음수가 포함되어 있습니다.");
    }

    public boolean isOneNumber(String expression) {
        try {
            Integer.parseInt(expression);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
}
