package racingcar.utils;

public class InputParser {

    public static String[] splitByComma(String input) {
        return input.split(",");
    }

    public static int parseStringToPositiveInt(String input) {
        try {
            return checkZeroOrNegative(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new RuntimeException("1 이상의 숫자만 입력해야합니다.");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private static int checkZeroOrNegative(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
        return number;
    }
}
