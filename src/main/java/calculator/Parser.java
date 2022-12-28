package calculator;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    private String content;

    public Parser(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Optional<String> getCustomDelimiter() {
        content = this.content.replace("\\n", "\n");
        Matcher m = pattern.matcher(content);
        if (m.find()) {
            content = m.group(2);
            return Optional.of(m.group(1));
        }
        return Optional.empty();
    }
}
