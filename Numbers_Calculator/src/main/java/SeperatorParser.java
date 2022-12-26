public class SeperatorParser {



    public String extract(String input) {
        if (isIncludingSeperator(input)) {
            return input.substring(input.indexOf("//") + 2, input.indexOf("\n"));
        }
        return ",|:";
    }

    public boolean isIncludingSeperator(String input) {
        return input.matches("^//(.*)\\n(.*)");
    }
}
