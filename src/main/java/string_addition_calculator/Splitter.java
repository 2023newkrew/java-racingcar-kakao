package string_addition_calculator;

import java.util.ArrayList;
import java.util.List;

public class Splitter {

    public static final int CUSTOM_SEPARATOR_POSITION = 4;
    public static final List<Character> SPECIAL_REGEX_CHARACTERS = new ArrayList<>();

    static {
        SPECIAL_REGEX_CHARACTERS.addAll(List.of('.', '^', '$', '*', '+', '-', '?', '(', ')', '[', ']', '{', '}', '\\', '|', '-', '/'));
    }

    public String[] split(String input) {
        String separatorRegex = ",|:";
        if (containsCustomSeparator(input)) {
            separatorRegex += parseCustomSeparatorRegex(input);
            String inputWithoutPrefix = input.substring(CUSTOM_SEPARATOR_POSITION);
            return inputWithoutPrefix.split(separatorRegex);
        }
        return input.split(separatorRegex);
    }

    private boolean containsCustomSeparator(String input) {
        return input.length() > 5 && input.charAt(0) == '/' && input.charAt(1) == '/' && input.charAt(3) == '\n';
    }

    private String parseCustomSeparatorRegex(String input) {
        char customSeparator = input.charAt(2);
        if (SPECIAL_REGEX_CHARACTERS.contains(customSeparator)) {
            return "|" + "\\" + customSeparator;
        }
        return "|" + customSeparator;
    }
}
