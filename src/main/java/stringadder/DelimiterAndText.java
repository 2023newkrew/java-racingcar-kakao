package stringadder;

public class DelimiterAndText {

    private final String delimiter;
    private final String text;

    public String getDelimiter() {
        return delimiter;
    }

    public String getText() {
        return text;
    }

    public DelimiterAndText(String delimiter, String text) {
        this.delimiter = delimiter;
        this.text = text;
    }
}
