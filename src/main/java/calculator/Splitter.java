package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Splitter {

    public List<Integer> split(String input){
        Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(input);
        String customDelimiter = "";
        String delimiters;

        if (m.find()) {
            input = input.split("\n")[1];
            customDelimiter = m.group(1);
        }

        delimiters = "[,;" + customDelimiter + "]";

        return arrayToList(input, delimiters);
    }

    private List<Integer> arrayToList(String input, String delimiters){
        try{
            return Arrays.stream(input.split(delimiters))
                    .mapToInt(e -> Integer.parseInt(e.trim()))
                    .boxed()
                    .collect(Collectors.toList());
        }catch (NumberFormatException numberFormatException){
            throw new RuntimeException("숫자가 아닌 문자가 포함되어있습니다.");
        }
    }
}
