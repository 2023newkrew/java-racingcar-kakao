package stringcalc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparatorParser {
    public List<String> parse(String input) {
        Pattern pattern = Pattern.compile("(?<=//)(.*?)(?=\n)");
        Matcher matcher = pattern.matcher(input);
        List<String> separators = new ArrayList<>();
        while (matcher.find()) {
            separators.add(matcher.group(1));
        }
        validateSeparatorLength(separators);
        return separators;
    }

    private void validateSeparatorLength(List<String> separators){
        for (String separator : separators) {
            checkLengthOne(separator);
        }
    }

    private void checkLengthOne(String separator){
        if (separator.length() != 1) {
            throw new RuntimeException();
        }
    }


}
