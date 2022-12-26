public class StringParser {


    public String[] split(String input) {
        return input.split(",|;");
    }

    public String[] split(String input, String customDelimiter) {
        return input.split(",|;|" + customDelimiter);
    }
}
