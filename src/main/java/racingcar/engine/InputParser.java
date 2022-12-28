package racingcar.engine;

public class InputParser {

    public String[] splitByComma(String input) {
        String[] result = input.split(",");
        if (result.length < 2) {
            throw new RuntimeException("경주에는 최소 2대 이상의 자동차가 필요합니다.");
        }
        return input.split(",");
    }

    public int parseStringToPositiveInt(String input) {
        try {
            return checkPositive(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new RuntimeException("1 이상의 숫자만 입력해야합니다.");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private int checkPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
        return number;
    }
}
