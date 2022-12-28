package calculator;

public class StringSplitter {
    private final String CUSTOM_DELIMITER_START = "//";
    private final String CUSTOM_DELIMITER_END = "\n";
    private final String DEFAULT_DELIMITER = ",|;";
    private final String delimiter;
    private final String input;

    public StringSplitter(String input) {
        this.input = input;
        this.delimiter = extractDelimiter();
    }

    public String extractDelimiter() {
        if (hasCustomDelimiter()) {
            return input.substring(2, input.indexOf(CUSTOM_DELIMITER_END));
        }
        return DEFAULT_DELIMITER;
    }

    public String[] split() {
        String str = input;
        if (str==null || str.isEmpty()) {
            return new String[]{"0"};
        }
        if (hasCustomDelimiter()) {
            str = input.substring(input.indexOf(CUSTOM_DELIMITER_END) + 1);
        }
        return convertEmptyToZero(str.split(delimiter));
    }


    public boolean hasCustomDelimiter() {
        if (input==null) {
            return false;
        }
        if (input.startsWith(CUSTOM_DELIMITER_START)
                && input.indexOf(CUSTOM_DELIMITER_END) > 1) {
            return true;
        }
        return false;
    }

    public String[] convertEmptyToZero(String[] arr) {
        String[] result = new String[arr.length];
        for (int i = 0; i<arr.length; i++) {
            result[i] = arr[i].isEmpty() ? "0" : arr[i];
        }
        return  result;
    }
}
