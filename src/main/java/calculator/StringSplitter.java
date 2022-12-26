package calculator;

public class StringSplitter {
    private final String delimiter;
    private final String input;

    public StringSplitter(String input) {
        this.input = input;
        this.delimiter = extractDelimiter();
    }

    public String extractDelimiter() {
        if (hasCustomDelimiter()) {
            return input.substring(2, input.indexOf("\n"));
        }
        return ",";
    }

    public String[] split() {
        String str = input;
        if (hasCustomDelimiter()) {
            str = input.substring(input.indexOf("\n") + 1);
        }
        return str.split(delimiter);
    }

    public boolean hasCustomDelimiter() {
        if (input.startsWith("//") && input.indexOf("\n") > 1) {
            return true;
        }
        return false;
    }
}
