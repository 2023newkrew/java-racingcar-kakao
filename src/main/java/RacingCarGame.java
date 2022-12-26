import java.util.Objects;

public class RacingCarGame {

    public int play(String input) {
        if (!Objects.isNull(input) && input.length() == 1) {
            return Integer.parseInt(input);
        }

        return 0;
    }

}
