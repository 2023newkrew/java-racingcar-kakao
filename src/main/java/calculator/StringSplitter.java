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
        return ",|;";
    }

    public String[] split() {
        String str = input;
        if (str==null || str.isEmpty()) return new String[]{"0"};
        if (hasCustomDelimiter()) {
            str = input.substring(input.indexOf("\n") + 1);
        }
        return convertEmptyToZero(str.split(delimiter));
    }


    public boolean hasCustomDelimiter() {
        if (input!=null && input.startsWith("//") && input.indexOf("\n") > 1) {
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
