package carracing.domain;

public class InputVerifier {
    public static void verifyName(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new RuntimeException("Invalid Name");
        }
    }

    public static void verifyNumberIsPos(int num) {
        if (num <= 0) {
            throw new RuntimeException("Invalid number for turns");
        }
    }
}
