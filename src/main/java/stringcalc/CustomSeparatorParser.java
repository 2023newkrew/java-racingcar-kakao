package stringcalc;

import java.util.ArrayList;
import java.util.List;

public class CustomSeparatorParser {

    public List<String> parse(String input) {
        String[] split = input.split("\n");
        List<String> separators = new ArrayList<>();
        for (int idx = 0; idx < split.length - 1; idx++) {
            validateSeparatorFormat(split[idx]);
            separators.add(split[idx].substring(2));
        }
        return separators;
    }

    private void validateSeparatorFormat(String separator){
        if (separator.length() != 3 || !separator.startsWith("//")) {
            throw new RuntimeException();
        }
    }

}
