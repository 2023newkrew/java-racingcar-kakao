package car_racing.domain;

public class StringParser {
    public static String[] parse(String inputString) {
        String[] splitStrings = inputString.split(",", -1);
        for (String splitString: splitStrings) {
            InputVerifier.verifyName(splitString);
        }
        return splitStrings;
    }
}
