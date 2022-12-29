package numberCalculator;

import java.util.regex.Pattern;

public class SeparatorParser {



    public String extract(String input) {
        if (isIncludingSeparator(input)) {
            return Pattern.quote(input.substring(input.indexOf("//") + 2, input.indexOf("\n")));
        }
        return ",|:";
    }


    public boolean isIncludingSeparator(String input) {
        return input.matches("^//(.*)\\n(.*)");
    }
}
