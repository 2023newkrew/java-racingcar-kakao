package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Splitter {

    public List<Integer> split(String input){
        String delimiters = "[,;";
        Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiters += customDelimiter;
            input = input.split("\n")[1];
        }
        delimiters += "]";

        return Arrays.stream(input.split(delimiters))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
