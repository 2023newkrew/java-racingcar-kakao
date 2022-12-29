package calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {
    private final String input;
    private final Matcher matcher;
    private String delimiter;
    private String purifiedInput;
    private static final Set<String> metaChar =
            new HashSet<>(Arrays.asList("?", "*", "+", "[", "{", "(", "}", "^", "$", "}", "]", "|"));
    // metachar : split 시 특별
    public DelimiterParser(String input) {
        this.input = input;
        this.delimiter = ",|:";
        this.matcher = Pattern.compile("//(.)\n(.*)").matcher(this.input);
        this.purifiedInput = input;
        checkCustomDelimiter();
    }
    public String getDelimiter() {
        return this.delimiter;
    }

    public String[] getPurifiedInputSplit() {
        return purifiedInput.split(delimiter);
    }

    private void checkCustomDelimiter() {
        if (hasCustomMatch()) {
            this.delimiter = this.matcher.group(1);
            this.purifiedInput = this.matcher.group(2);
        }
        checkMetaChar();
    }

    private boolean hasCustomMatch(){
        return this.matcher.find();
    }
    private void checkMetaChar(){
        if (metaChar.contains(delimiter)){
            delimiter = "\\"+delimiter;
        }
    }
}
