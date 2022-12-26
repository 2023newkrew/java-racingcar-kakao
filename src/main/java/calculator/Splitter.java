package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Splitter {

    public List<Integer> split(String input){
        Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(input);
        input = input.split("\n")[1];
        String customDelimiter = "";
        String delimiters;

        if (m.find()) {
            customDelimiter = m.group(1);
        }

        delimiters = "[,;" + customDelimiter + "]";

        return Arrays.stream(input.split(delimiters))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
