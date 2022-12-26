import java.util.Objects;

public class Calculator {
    public int calculate(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return 0;
        }
        return -1;
    }
}
