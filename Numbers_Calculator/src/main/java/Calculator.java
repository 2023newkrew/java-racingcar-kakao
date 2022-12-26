import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {


    public List<Integer> splitNumbers(String originalString, String seperator) {
        if (originalString.isEmpty()) return Collections.emptyList();
        String[] splittedStr = originalString.split(Pattern.quote(seperator));
        return Arrays.stream(splittedStr).map(str -> Integer.parseInt(str)).collect(Collectors.toList());
    }

    public Integer summarizeNumbers(String s, String seperator) {
        List<Integer> numbers = splitNumbers(s, seperator);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
