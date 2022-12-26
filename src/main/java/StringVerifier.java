public class StringVerifier {

    private StringVerifier(){}

    public static boolean isInteger(String s) {
        try {
            int parsedInt = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isPositive(Integer i) {
        return i >= 0;
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
