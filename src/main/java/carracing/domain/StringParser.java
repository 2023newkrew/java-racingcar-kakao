package carracing.domain;

public class StringParser {
    public String[] parse(String inputString) {
        return inputString.split(",", -1);
    }
}
