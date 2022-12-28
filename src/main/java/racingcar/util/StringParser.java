package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    public static List<String> parse(String text) {
        String[] texts = text.split(",");

        return Arrays.asList(texts);
    }

    public static int parseTurn(String turn) {
        try {
            return Integer.parseInt(turn);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
