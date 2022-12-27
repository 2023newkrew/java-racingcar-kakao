package racingcar;

public class InputParser {

    public String[] splitByComma(String input) {
        return input.split(",");
    }

    public int parseToInt(String input) {
        return Integer.parseInt(input);
    }
}
