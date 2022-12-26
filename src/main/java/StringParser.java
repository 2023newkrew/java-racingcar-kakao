public class StringParser {


    public String[] split(String input) {
        return input.split(",|;");
    }

    public String[] split(String input, String customDelimiter) {
        return input.split(",|;|" + customDelimiter);
    }

    public int parseInt(String number) {
        int parsedNumber = Integer.parseInt(number);
        if (parsedNumber < 0) {
            throw new RuntimeException();
        }
        return parsedNumber;
    }
}
