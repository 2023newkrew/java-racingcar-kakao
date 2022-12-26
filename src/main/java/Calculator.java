import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public int calculate(Prompt prompt) {
        if(prompt.isEmptyInput()) {
            return 0;
        }
        prompt.changePromptIfExistCustomDelimiter();
        return calculateWithDelimiter(prompt);
    }

    private int calculateWithDelimiter(Prompt prompt) {
        String[] tokens = prompt.getStringTokens();
        int ret = 0;
        for (String token : tokens) {
            ret += Integer.parseInt(token);
        }
        return ret;
    }

}
