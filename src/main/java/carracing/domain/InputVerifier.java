package carracing.domain;

public class InputVerifier {
    public static void verifyNumberIsPos(int num) {
        if (num <= 0) {
            throw new RuntimeException("Invalid number for turns");
        }
    }
}
