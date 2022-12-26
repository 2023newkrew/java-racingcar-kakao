import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {



    public List<Integer> split(String originalString) {
        if (originalString.isEmpty()) return Collections.emptyList();
        String[] splittedStr = originalString.split(",|:");
        return Arrays.stream(splittedStr).map(str -> Integer.parseInt(str)).collect(Collectors.toList());
    }

    public Integer summarizeNumbers(String s) {
        List<Integer> numbers = split(s);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
