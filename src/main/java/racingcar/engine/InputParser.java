package racingcar.engine;

public class InputParser {

    public String[] splitByComma(String input) {
        String[] result = input.split(",");
        if (result.length < 2) {
            throw new RuntimeException("경주에는 최소 2대 이상의 자동차가 필요합니다.");
        }
        return input.split(",");
    }

    public int parseToInt(String input) {
        try {
            int number = Integer.parseInt(input);
            checkPositive(number);
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException("1 이상의 숫자만 입력해야합니다.");
        }
    }

    private void checkPositive(int number) {
        if (number <= 0) {
            throw new NumberFormatException();
        }
    }
}
