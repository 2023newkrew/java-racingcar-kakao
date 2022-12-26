public class StringVerifier {
    public boolean isInteger(String s) {
        try {
            int parsedInt = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isPositive(Integer i) {
        return i >= 0;
    }

    public boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
