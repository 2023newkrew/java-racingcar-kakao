package stringcalculator;

public class StringCalculator {
    private final String delimiter = ",|:";

    public String[] split(String s) {
        if (s == null || s.isEmpty()) {
            return new String[]{};
        }
        return s.split(delimiter);
    }
}
